
# Yelp Fusion

[Yelp Fusion](https://www.yelp.com/developers) includes better tools for developers to build with the new Yelp Fusion API, which provides access to the industry leading Yelp content and data, a revamped developer portal, and cool new partner integration examples to inspire developers.

Our [getting started tutorial](https://www.yelp.com/developers/documentation/v3/get_started) provides step-by-step instructions to get up and running with the new Yelp Fusion API.

## What’s new?

We’re exposing two new features as part of the developer preview: [autocomplete](https://www.yelp.com/developers/documentation/v3/autocomplete) and [transactions search](https://www.yelp.com/developers/documentation/v3/transactions_search).

As a user performs a search, autocomplete will help them find what they want (some might even say we have the ability to read their minds). With autocomplete, a user’s search experience will feel much more intuitive.

The API now exposes a search endpoint for businesses that let you order online, specifically food delivery. If you’re interested in working with businesses which deliver food to your users, then look no further! Any food delivery business available on Yelp (such as Eat24, ChowNow, delivery.com and EatStreet) will be returned through this endpoint.

## What’s changed?

By default, we’re also providing more business data. The business endpoint will now return hours, pricing, and 3 hi-res photos. A reviews endpoint has been added that’ll provide you with 3 review excerpts for a business from Yelp users.

The new API will use API Keys for all requests as opposed to OAuth 1.0a, allowing for simpler access to the API. Check out the [getting started tutorial](https://www.yelp.com/developers/documentation/v3/get_started) or the [authentication guide](https://www.yelp.com/developers/documentation/v3/authentication) for step-by-step instructions on authenticating.

We hope that the new Yelp Fusion API has made it more powerful yet simpler for developers to use.

## Clientlibs
Client libraries are full-featured interface modules that handle much of the request and response handling for the Yelp Fusion API.

### Official
#### iOS
The official iOS client library is [yelp-ios](https://github.com/Yelp/yelp-ios).

### Unofficial
#### Node.js
* [tonybadguy/yelp-fusion](https://github.com/tonybadguy/yelp-fusion)
* [danieljin/yelpv3](https://github.com/danieljin/yelpv3)

#### PHP
* [stevenmaguire/yelp-php](https://github.com/stevenmaguire/yelp-php)

#### Swift
* [chrisdhaan/CDYelpFusionKit](https://github.com/chrisdhaan/CDYelpFusionKit)

## Code samples
This Github repo includes several small code samples:
* [Node.js](https://github.com/Yelp/yelp-fusion/tree/master/fusion/node)
* [PHP](https://github.com/Yelp/yelp-fusion/tree/master/fusion/php)
* [Python](https://github.com/Yelp/yelp-fusion/tree/master/fusion/python)
* [Ruby](https://github.com/Yelp/yelp-fusion/tree/master/fusion/ruby)
* [Swift](https://github.com/Yelp/yelp-fusion/tree/master/fusion/swift)

## Feedback

If you have any feedback for us about Yelp Fusion (bugs, suggestions, etc), please create a [new issue](https://github.com/Yelp/yelp-fusion/issues/new) on this repo. We'll be monitoring and responding to issues opened up here.

We've put up an [FAQ](https://www.yelp.com/developers/faq) to try to help answer questions you might have.
