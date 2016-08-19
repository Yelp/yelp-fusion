# /transactions/{transaction_type}/search

This endpoint returns a list of businesses which support certain transactions.

## Request

```
GET https://api.yelp.com/v3/transactions/{transaction_type}/search
```

Valid values for ``transaction_type`` are:

- ``delivery``: food delivery.

> **Note**
>
> Currently, this endpoint only supports food delivery in the US.


## Parameters

These parameters should be in the query string.

| Name | Type | Description |
|:------|:------|:-------------|
| ``latitude`` | decimal | Required when location isn't provided. Latitude of the location you want to deliver to. |
| ``longitude`` | decimal | Required when location isn't provided. Longitude of the location you want to deliver to. |
| ``location`` | string | Required when latitude and longitude aren't provided. Address of the location you want to deliver to. |

## Response body

```json
{
  "total": 144,
  "businesses": [
    {
      "id": "north-india-restaurant-san-francisco",
      "price": "$$",
      "url": "https://www.yelp.com/biz/north-india-restaurant-san-francisco",
      "rating": 4,
      "location": {
        "zip_code": "94105",
        "state": "CA",
        "country": "US",
        "city": "San Francisco",
        "address2": "",
        "address3": "",
        "address1": "123 Second St"
      },
      "categories": [
        {
          "alias": "indpak",
          "title": "Indian"
        }
      ],
      "phone": "+14153481234",
      "coordinates": {
        "longitude": -122.399305736113,
        "latitude": 37.787789124691
      },
      "image_url": "http://s3-media4.fl.yelpcdn.com/bphoto/howYvOKNPXU9A5KUahEXLA/o.jpg",
      "name": "North India Restaurant",
      "review_count": 615
    },
    // ...
  ]
}
```

| Name | Type | Description |
|:------|:------|:-------------|
| ``total`` | int | The total number of business Yelp finds based on the search criteria. Sometimes, the value may exceed 1000. In such case, you still can only get up to 1000 businesses. |
| ``businesses`` | object[] | A list of business Yelp finds based on the search criteria. |
| ``businesses[x].id`` | string | Yelp id of this business. |
| ``businesses[x].name`` | string | Name of this business. |
| ``businesses[x].image_url`` | string | URL of photo for this business. |
| ``businesses[x].url`` | string | URL for business page on Yelp. |
| ``businesses[x].price`` | string | Price level of the business. Value is one of $, $$, $$$ and $$$$. |
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
