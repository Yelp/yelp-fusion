# Yelp Fusion Code Sample for Node.js

This is a simple script to perform a search on the Yelp Fusion API using an unofficial Node.js client library [tonybadguy/yelp-fusion](https://github.com/tonybadguy/yelp-fusion). This should be compatible with Node.js 4 and higher.

## Setup

Clone the repo:

```
$ git clone https://github.com/Yelp/yelp-fusion.git
```

Go into the directory:

```
$ cd yelp-fusion/fusion/node
```

Install the dependences:

```
$ npm install 
```

Open up the `sample.js` file and put your clientId and clientSecret from the [manage app page](https://www.yelp.com/developers/v3/manage_app)

```javascript
// Place holders for Yelp Fusion's OAuth 2.0 credentials. Grab them
// from https://www.yelp.com/developers/v3/manage_app
const clientId = '<YOUR_CLIENT_ID>';
const clientSecret = '<YOUR_CLIENT_SECRET>';
```

You may optionally update the search request
```javascript
const searchRequest = {
  term:'Four Barrel Coffee',
  location: 'san francisco, ca'
};
```

## Usage

Once you're all setup, you should be able to run the script directly from the command line:

```
$ node sample.js
```

It will print the first business returned:
```javascript
{
    "review_count": 95,
    "rating": 4,
    "name": "Four Barrel Coffee",
    "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/tu3R-kxZjtJS0yeSYQlsbg/o.jpg",
    "phone": "+14157158296",
    "distance": 4791.2602603899995,
    "id": "four-barrel-coffee-san-francisco-4",
    "price": "$$",
    "is_closed": false,
    "coordinates": {
        "latitude": 37.7289353,
        "longitude": -122.4036865
    },
    "categories": [
        {
            "alias": "coffee",
            "title": "Coffee & Tea"
        }
    ],
    "location": {
        "address3": "",
        "country": "US",
        "city": "San Francisco",
        "state": "CA",
        "zip_code": "94134",
        "address2": "",
        "address1": "2 Burrows St"
    },
    "url": "https://www.yelp.com/biz/four-barrel-coffee-san-francisco-4?adjust_creative=00hTIAj8PYj5vbaVtbpZJw&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=00hTIAj8PYj5vbaVtbpZJw"
}
```

