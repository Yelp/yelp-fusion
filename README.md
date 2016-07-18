
# Yelp API v3

The [Yelp API v3](https://www.yelp.com/developers/v3/preview) is [now open](http://engineeringblog.yelp.com/2016/07/announcing-yelp-api-v3-developer-preview.html) to developers to test out and build with. All of the documentation for the API lives inside of this repo, along with some tutorials and other additional information.

Our [getting started tutorial](/docs/tutorials/get-start-yelp-api-v3.md) provides step-by-step instructions to get up and running with the new API.

## What’s new?

We’re exposing two new features as part of the developer preview: [autocomplete](/docs/api-references/autocomplete.md) and [transaction search](/docs/api-references/transactions-search.md).

As a user performs a search, autocomplete will help them find what they want (some might even say we have the ability to read their minds). With autocomplete, a user’s search experience will feel much more intuitive.

The API now exposes a search endpoint for businesses that let you order online, specifically food delivery. If you’re interested in working with businesses which deliver food to your users, then look no further! Any food delivery business available on Yelp (such as Eat24, ChowNow, Delivery.com and EatStreet) will be returned through this endpoint.

## What’s changed?

By default, we’re also providing more business data. The business endpoint will now return hours, pricing, and 3 hi-res photos. A reviews endpoint has been added that’ll provide you with 3 review excerpts for a business from Yelp users.

The new API will use OAuth 2.0 to for all requests as opposed to OAuth 1.0a. We’ve exposed a client credentials flow which will allow for simpler access to the API. Checkout the [getting started tutorial](/docs/tutorials/get-start-yelp-api-v3.md#get-an-access-token) for step-by-step instructions on authenticating with OAuth 2.0.

We hope that the new design of the API has made it more powerful yet simpler for developers to use. The endpoint names, parameters, and responses should be easier to understand and overall much more consistent.

## Feedback

If you have any feedback for us about the API (bugs, suggestions, etc), please create a [new issue](https://github.com/Yelp/yelp-api-v3/issues/new) on this repo. We'll be monitoring and responding to issues opened up here.

We've put up an [FAQ](/docs/others/faq.md) to try to help answer questions you might have.
