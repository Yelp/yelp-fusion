# /businesses/search/phone

This endpoint returns a list of businesses based on the provided phone number. It is possible for more than one businesses having the same phone number (for example, chain stores with the same +1 800 phone number).

## Request

```
GET https://api.yelp.com/v3/businesses/search/phone
```

## Parameters

These parameters should be in the query string.

| Name | Type | Description |
|:------|:------|:-------------|
| phone | string | Required. Phone number of the business you want to search for. It must start with + and include the country code, like +14159083801. |

## Response body

```json
{
  "total": 1,
  "businesses": [
    {
      "rating": 4.5,
      "price": "$$$$",
      "phone": "+14157492060",
      "id": "gary-danko-san-francisco",
      "categories": [
        {
          "alias": "newamerican",
          "title": "American (New)"
        }
      ],
      "review_count": 4525,
      "name": "Gary Danko",
      "url": "https://www.yelp.com/biz/gary-danko-san-francisco",
      "coordinates": {
        "latitude": 37.80587,
        "longitude": -122.42058
      },
      "image_url": "https://s3-media3.fl.yelpcdn.com/bphoto/--8oiPVp0AsjoWHqaY1rDQ/o.jpg",
      "location": {
        "city": "San Francisco",
        "country": "US",
        "address2": "",
        "address3": "",
        "state": "CA",
        "address1": "800 N Point St",
        "zip_code": "94109"
      }
    }
  ]
}
```

| Name | Type | Description |
|:------|:------|:-------------|
| ``total`` | int | The total number of business Yelp finds based on the search criteria. |
| ``businesses`` | object[] | A list of business Yelp finds based on the search criteria. |
| ``businesses[x].id`` | string | Yelp id of this business. It can be used in [/businesses/{id}](businesses-id.md) and [/businesses/{id}/reviews](businesses-id-reviews.md). |
| ``businesses[x].name`` | string | Name of this business. |
| ``businesses[x].image_url`` | string | URL of photo for this business. |
| ``businesses[x].url`` | string | URL for business page on Yelp. |
| ``businesses[x].price`` | string | Price level of the business. Value is one of $, $$, $$$ and $$$. |
| ``businesses[x].phone`` | string | Phone number of the business. |
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
