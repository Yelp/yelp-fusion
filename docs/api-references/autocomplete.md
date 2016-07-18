# /autocomplete

This endpoint returns autocomplete suggestions for search keywords, businesses and categories, based on the input text.

## Request

```
GET https://api.yelp.com/v3/autocomplete
```

## Parameters

These parameters should be in query string.

| Name | Type | Description |
|:------|:------|:----------|
| ``text`` | string | Required. Text to return autocomplete suggestions for. |
| ``latitude`` | decimal | Required if want to get autocomplete suggestions for businesses. Latitude of the location to look for business autocomplete suggestions. |
| ``longitude`` | decimal | Required if want to get autocomplete suggestions for businesses. Longitude  of the location to look for business autocomplete suggestions. |
| ``locale`` | string | Optional. Specify the locale to return the autocomplete suggestions in. See the [list of supported locales](supported-locales.md). |

## Response body

```json
{
  "terms": [
    {
      "text": "Delivery"
    }
  ],
  "businesses": [
    {
      "name": "Delfina",
      "id": "YqvoyaNvtoC8N5dA8pD2JA"
    },
    {
      "text": "Delarosa",
      "id": "vu6PlPyKptsT6oEq50qOzA"
    },
    {
      "text": "Pizzeria Delfina",
      "id": "bai6umLcCNy9cXql0Js2RQ"
    }
  ],
  "categories": [
    {
      "alias": "delis",
      "title": "Delis"
    },
    {
      "alias": "fooddeliveryservices",
      "title": "Food Delivery Services"
    },
    {
      "alias": "couriers",
      "title": "Couriers & Delivery Services"
    }
  ]
}
```

| Name | Type | Description |
|:------|:------|:-------------|
| ``terms`` | object[] | A list of term autocomplete suggestions based on the input text. |
| ``terms[x].text`` | string | The text content of the term autocomplete suggestion. |
| ``businesses`` | object[] | A list of business autocomplete suggestions based on the input text. |
| ``businesses[x].name`` | string | Name of the business. |
| ``businesses[x].id`` | string | Yelp id of the business. It can be used in [/businesses/{id}](businesses-id.md) and [/businesses/{id}/reviews](businesses-id-reviews.md). Notice that right now it's returning an encoded id. We are working on returning friendly id like "gary-danko-san-francisco". Functionality wise, they are the same. |
| ``categories`` | object[] | A list of category autocomplete suggestions based on the input text. |
| ``categories[x].title`` | string | Title of a category for display purpose. |
| ``categories[x].alias`` | string | Alias of a category, when searching for business in certain categories, use alias rather than the title. |
