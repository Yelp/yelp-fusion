package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"net/url"
	"path"

	"github.com/adayNU/yelp"
)

// APIKey is a Yelp Fusion API key. Grab it from https://www.yelp.com/developers/v3/manage_app.
const APIKey = ""

// Constants - do not change these.
const (
	APIHost      = "api.yelp.com"
	SearchPath   = "/v3/businesses/search"
	BusinessPath = "/v3/businesses" // trailing / because we append the business id to the path
)

// Default values - changeable.
const (
	SearchLimit = "5"
)

// search returns a response from the Fusion search endpoint. Example usage:
//	search("Buffalo Wings", "Evanston, IL")
func search(term, location string) (*yelp.SearchResponse, error) {
	var params = url.Values{
		"term":     []string{term},
		"location": []string{location},
		"limit":    []string{SearchLimit},
	}

	var resp, err = request(SearchPath, params)

	var sr = &yelp.SearchResponse{}
	err = json.Unmarshal(resp, sr)
	if err != nil {
		return nil, err
	}

	return sr, nil
}

// getBusiness returns a response from the Fusion business endpoint for a business |id|.
// Example usage:
//	getBusiness("buffalo-joes-evanston")
func getBusiness(id string) (*yelp.Business, error) {
	var resp, err = request(path.Join(BusinessPath, id), url.Values{})

	var b = &yelp.Business{}
	err = json.Unmarshal(resp, b)
	if err != nil {
		return nil, err
	}

	return b, nil
}

// requests makes a response to the endpoint |path| with parameters |v|.
func request(path string, v url.Values) ([]byte, error) {
	var r = &http.Request{
		Method: "GET",
		URL: &url.URL{
			Scheme:   "https",
			Host:     APIHost,
			Path:     path,
			RawQuery: v.Encode(),
		},
		Header: http.Header{
			"Authorization": []string{"Bearer " + APIKey},
		},
	}

	var resp, err = http.DefaultClient.Do(r)
	if err != nil {
		return nil, err
	}

	defer resp.Body.Close()

	var body []byte
	body, err = ioutil.ReadAll(resp.Body)
	if err != nil {
		return nil, err
	}

	return body, nil
}

func main() {
	if APIKey == "" {
		panic("No API Key configured!")
	}

	var resp, err = search("Buffalo Wings", "Evanston, IL")
	if err != nil {
		panic(err)
	}

	fmt.Println("The best place to buy wings is: ", resp.Businesses[0].Name)

	biz, err := getBusiness(resp.Businesses[0].Alias)
	if err != nil {
		panic(err)
	}
	fmt.Println("It's phone number is: ", biz.Phone)
}
