# /businesses/{id}/reviews
This endpoint returns the up to three reviews of a business.

## Request

To use this endpoint, make the **GET** request to the following URL with the id of the business you want to get reviews for. Normally, you'll get the business id from [/businesses/search](businesses-search.md), [/businesses/search/phone](businesses-phone-search.md), [/transactions/{transaction_type}/search](businesses-transaction-search.md) or [/autocomplete](autocomplete.md).

```
GET https://api.yelp.com/v3/businesses/{id}/reviews
```

## Parameters

None.

## Response body

```json
{
  "reviews": [
    {
      "url": "https://www.yelp.com/biz/gary-danko-san-francisco?hrid=OtEqx7ZndmJGqi_XR83MVQ",
      "text": "best place to dine in a city known for gourmet cuisine",
      "user": {
        "image_url": "http://s3-media4.fl.yelpcdn.com/photo/JkdZsw_ASWWPYIsA2W5fsQ/o.jpg",
        "name": "Jared K."
      },
      "rating": 5
    },
    {
      "url": "https://www.yelp.com/biz/gary-danko-san-francisco?hrid=1hulB9R4fB7b8AbZq4jZVg",
      "text": "Great food. Boring ambiance.",
      "user": {
        "image_url": "http://s3-media3.fl.yelpcdn.com/photo/TSwMsQlpvmCcTwT9oPfNug/o.jpg",
        "name": "Jeremy S."
      },
      "rating": 4
    },
    {
      "url": "https://www.yelp.com/biz/gary-danko-san-francisco?hrid=e_f9ELbSlKiPued9mVVTqw",
      "text": "Amazing food, perfect service.  Pretty expensive, but I think per dollar it's better than a lot of the higher end places.",
      "user": {
        "image_url": "http://s3-media4.fl.yelpcdn.com/photo/JpvIXquK9flx32lJJivTLg/o.jpg",
        "name": "Russel S."
      },
      "rating": 5
    }
  ],
  "total": 3
}
```

| Name | Type | Description |
|:-----|:-----|:------------|
| ``total`` | int | The total number of returned reviews of this business. Maximum 3 reviews will be returned. |
| ``reviews`` | object[] | A list of up to three reviews of this business. |
| ``reviews[x].text`` | string | Text excerpt of this review. |
| ``reviews[x].url`` | string | Url of this review. |
| ``reviews[x].rating`` | decimal | Rating of the business associated with this review. |
| ``reviews[x].user`` | object | The user who wrote the review. |
| ``reviews[x].user.name`` | string | Name of the user. |
| ``reviews[x].user.image_url`` | string | Url of the user's profile photo. |
