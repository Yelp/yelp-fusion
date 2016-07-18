# /businesses/search

This endpoint returns a list of businesses based on the provided search criteria. It has some basic information about the business. To get detailed information and reviews, please use the business id returned here and refer to [/businesses/{id}](businesses-id.md) and [/businesses/{id}/reviews](businesses-id-reviews.md) endpoints.

## Request

```
GET https://api.yelp.com/v3/businesses/search
```

## Parameters

These parameters should be in the query string.

| Name | Type | Description |
|:------|:------|:----------|
| term | string | Optional. Search term (e.g. "food", "restaurants"). If term isn’t included we search everything. The term keyword also accepts business names such as "Starbucks". |
| location | string | Required if either latitude or longitude is not provided. Specifies the combination of "address, neighborhood, city, state or zip, optional country" to be used when searching for businesses. |
| latitude | decimal | Required if location is not provided. Latitude of the location you want to search near by. |
| longitude | decimal | Required if location is not provided. Longitude of the location you want to search near by. |
| radius | int | Optional. Search radius in meters. If the value is too large, a AREA\_TOO\_LARGE error may be returned. The max value is 40000 meters (25 miles). |
| categories | string | Optional. Categories to filter the search results with. See the [list of supported categories](https://www.yelp.com/developers/documentation/v2/all_category_list). The category filter can be a list of comma delimited categories. For example, "bars,french" will filter by Bars and French. The category identifier should be used (for example "discgolf", not "Disc Golf"). |
| locale | string | Optional. Specify the locale to return the business information in. See the [list of supported locales](supported-locales.md). |
| limit | int | Optional. Number of business results to return. By default, it will return 20. |
| offset | int | Optional. Offset the list of returned business results by this amount. |
| sort_by | string | Optional. Sort the results by one of the these modes: best\_match, rating, review\_count or distance. By default it's best_match. The rating sort is not strictly sorted by the rating value, but by an adjusted rating value that takes into account the number of ratings, similar to a bayesian average. This is so a business with 1 rating of 5 stars doesn’t immediately jump to the top. |
| pricing_filter | string | Optional. Pricing levels to filter the search result with: 1 = $, 2 = $$, 3 = $$$, 4 = $$$$. The pricing filter can be a list of comma delimited pricing levels. For example, "1, 2, 3" will filter the results to show the ones that are $, $$, or $$$. |
| open\_now\_filter | boolean | Optional. Default to false. When set to true, only return the businesses opening now. |

## Response body

```json
{
  "total": 8228,
  "businesses": [
    {
      "rating": 4,
      "price": "$",
      "phone": "+14152520800",
      "id": "four-barrel-coffee-san-francisco",
      "categories": [
        {
          "alias": "coffee",
          "title": "Coffee & Tea"
        }
      ],
      "review_count": 1738,
      "name": "Four Barrel Coffee",
      "url": "https://www.yelp.com/biz/four-barrel-coffee-san-francisco",
      "coordinates": {
        "latitude": 37.7670169511878,
        "longitude": -122.42184275
      },
      "image_url": "http://s3-media2.fl.yelpcdn.com/bphoto/MmgtASP3l_t4tPCL1iAsCg/o.jpg",
      "location": {
        "city": "San Francisco",
        "country": "US",
        "address2": "",
        "address3": "",
        "state": "CA",
        "address1": "375 Valencia St",
        "zip_code": "94103"
      }
    },
    // ...
  ]
}
```

| Name | Type | Description |
|:------|:------|:-------------|
| ``total`` | int | The total number of business Yelp finds based on the search criteria. |
| ``businesses`` | object[] | A list of business Yelp finds based on the search criteria. |
| ``businesses[x].id`` | string | Yelp id of this business. |
| ``businesses[x].name`` | string | Name of this business. |
| ``businesses[x].image_url`` | string | URL of photo for this business. |
| ``businesses[x].url`` | string | URL for business page on Yelp. |
| ``price`` | string | Price level of the business. Value is one of $, $$, $$$ and $$$$. |
| ``phone`` | string | Phone number of the business. |
| ``businesses[x].rating`` | decimal | Rating for this business (value ranges from 1, 1.5, ... 4.5, 5). |
| ``businesses[x].review_count`` | int | Number of reviews for this business. |
| ``businesses[x].categories`` | object[] | A list of category title and alias pairs associated with this business. |
| ``businesses[x].categories[x].alias`` | string | Alias of a category, when searching for business in certain categories, use alias rather than the title. |
| ``businesses[x].categories[x].title`` | string | Title of a category for display purpose. |
| ``businesses[x].coordinates`` | object | The coordinates of this business. |
| ``businesses[x].coordinates.latitude`` | decimal | The latitude of this business. |
| ``businesses[x].coordinates.longitude`` | decimal | The longitude of this business. |
| ``businesses[x].location`` | object | The location of this business, including address, city, state, zip code and country. |
| ``businesses[x].location.address1`` | string | Street address of this business. |
| ``businesses[x].location.address2`` | string | Street address of this business, continued. |
| ``businesses[x].location.address3`` | string | Street address of this business, continued. |
| ``businesses[x].location.city`` | string | City of this business. |
| ``businesses[x].location.state`` | string | [ISO 3166-2](http://en.wikipedia.org/wiki/ISO_3166-2) State code of this business. |
| ``businesses[x].location.zip_code`` | string | [Zip code](http://en.wikipedia.org/wiki/Postal_code) of this business. |
| ``businesses[x].location.country`` | string | [ISO 3166-1](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country code of this business. |
