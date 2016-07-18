# /businesses/{id}

This endpoint returns the detail information of a business. Normally, you'll get the business id from [/businesses/search](businesses-search.md), [/businesses/search/phone](businesses-phone-search.md), [/transactions/{transaction_type}/search](businesses-transaction-search.md) or [/autocomplete](autocomplete.md). To get review information of a business, please refer to [/businesses/{id}/reviews](businesses-id-reviews.md) endpoint.

## Request

```
GET https://api.yelp.com/v3/businesses/{id}
```

## Parameters

None.

## Response body

```json
{
  "id": "gary-danko-san-francisco",
  "name": "Gary Danko",
  "image_url": "https://s3-media4.fl.yelpcdn.com/bphoto/--8oiPVp0AsjoWHqaY1rDQ/o.jpg",
  "url": "https://www.yelp.com/biz/gary-danko-san-francisco",
  "price": "$$$$",
  "rating": 4.5,
  "review_count": 4521,
  "photos": [
    "http://s3-media3.fl.yelpcdn.com/bphoto/--8oiPVp0AsjoWHqaY1rDQ/o.jpg",
    "http://s3-media2.fl.yelpcdn.com/bphoto/ybXbObsm7QGw3SGPA1_WXA/o.jpg",
    "http://s3-media3.fl.yelpcdn.com/bphoto/7rZ061Wm4tRZ-iwAhkRSFA/o.jpg"
  ],
  "hours": [
    {
      "hours_type": "REGULAR",
      "open": [
        {
          "is_overnight": false,
          "end": "2200",
          "day": 0,
          "start": "1730"
        },
        {
          "is_overnight": false,
          "end": "2200",
          "day": 1,
          "start": "1730"
        },
        {
          "is_overnight": false,
          "end": "2200",
          "day": 2,
          "start": "1730"
        },
        {
          "is_overnight": false,
          "end": "2200",
          "day": 3,
          "start": "1730"
        },
        {
          "is_overnight": false,
          "end": "2200",
          "day": 4,
          "start": "1730"
        },
        {
          "is_overnight": false,
          "end": "2200",
          "day": 5,
          "start": "1730"
        },
        {
          "is_overnight": false,
          "end": "2200",
          "day": 6,
          "start": "1730"
        }
      ],
      "is_open_now": false
    }
  ],
  "categories": [
    {
      "alias": "newamerican",
      "title": "American (New)"
    }
  ],
  "coordinates": {
    "latitude": 37.80587,
    "longitude": -122.42058
  },
  
  "location": {
    "city": "San Francisco",
    "country": "US",
    "address2": "",
    "address3": "",
    "state": "CA",
    "address1": "800 N Point St",
    "zip_code": ""
  }
}
```

| Name | Type | Description |
|:------|:------|:-------------|
| ``id`` | string | Yelp id of this business. |
| ``name`` | string | Name of this business. |
| ``image_url`` | string | URL of photo for this business. |
| ``url`` | string | URL for business page on Yelp. |
| ``price`` | string | Price level of the business. Value is one of $, $$, $$$ and $$$. |
| ``rating`` | decimal | Rating for this business (value ranges from 1, 1.5, ... 4.5, 5). |
| ``review_count`` | int | Number of reviews for this business. |
| ``photos`` | string[] | URLs of up to three photos of the business. |
| ``hours`` | object[] | Opening hours of the business. |
| ``hours[x].is_open_now`` | boolean | Whether the business is currently open or not. |
| ``hours[x].hours_type`` | string | The type of the opening hours information. Right now, always return ``REGULAR``. |
| ``hours[x].open`` | object[] | The detail opening hours of each day in a week. |
| ``hours[x].open[x].day`` | int | From 0 to 6, representing day of the week from Sunday to Saturday. Notice that you may get the same day of the week more than once if the business has more than one opening time slots. |
| ``hours[x].open[x].start`` | string | Start of the opening hours in a day, in [military time](https://en.wikipedia.org/wiki/24-hour_clock#Military_time), like 1000 means 10 AM. |
| ``hours[x].open[x].end`` | string | End of the opening hours in a day, in [military time](https://en.wikipedia.org/wiki/24-hour_clock#Military_time), like 2130 means 9:30 PM. |
| ``hours[x].open[x].is_overnight`` | boolean | Whether the business opens overnight or not. When this is true, the end time will be lower than the start time. |
| ``categories`` | object[] | A list of category title and alias pairs associated with this business. |
| ``categories[x].alias`` | string | Alias of a category, when searching for business in certain categories, use alias rather than the title. |
| ``categories[x].title`` | string | Title of a category for display purpose. |
| ``coordinates`` | object | The coordinates of this business. |
| ``coordinates.latitude`` | decimal | The latitude of this business. |
| ``coordinates.longitude`` | decimal | The longitude of this business. |
| ``location`` | object | The location of this business, including address, city, state, zip code and country. |
| ``location.address1`` | string | Street address of this business. |
| ``location.address2`` | string | Street address of this business, continued. |
| ``location.address3`` | string | Street address of this business, continued. |
| ``location.city`` | string | City of this business. |
| ``location.state`` | string | [ISO 3166-2](http://en.wikipedia.org/wiki/ISO_3166-2) State code of this business. |
| ``location.zip_code`` | string | [Zip code](http://en.wikipedia.org/wiki/Postal_code) of this business. |
| ``location.country`` | string | [ISO 3166-1](http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country code of this business. |
