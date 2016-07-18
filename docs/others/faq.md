# FAQ

## General questions

#### What’s the difference between versions 2.0 and 3.0 of the Yelp API?

Yelp’s v3 API provides new functionality such as [Transaction search](../api-references/transactions-search.md) and [Autocomplete](../api-references/autocomplete.md), more powerful search filters, more data and better authentication via OAuth 2.0. For details, please check out our [announcement](http://engineeringblog.yelp.com/2016/07/announcing-yelp-api-v3-developer-preview.html) on Yelp Engineering Blog.

#### How can I get access?

Simply go to [Yelp developer website](https://www.yelp.com/developers/v3/preview), click the **Register for Access** button to create an app with Yelp. Then you'll get your client id and secret, which you can use to call our API. The detail instructions are at [Get started with Yelp API v3](../tutorials/get-start-yelp-api-v3.md). Please make sure you fully agree with our [API Terms of Use](https://www.yelp.com/developers/api_terms) and [Display Requirements](https://www.yelp.com/developers/display_requirements).

#### Is API v3 ready for production use of my app?

No. It's in developer preview phase. It may have issues. We may introduce breaking changes. And we don't provide any SLA at this phase. This is the time for you to try it out and give us feedback. We do try to address your feedback as soon as possible.

#### How do I ask questions and provide feedback?

Just open issues at https://github.com/Yelp/yelp-api-v3/issues.

#### How many API requests do I receive? What happens if I exceed my daily limit?

By default, you’ll receive 25,000 calls per day. If you expect to hit this rate limit, please contact api@yelp.com with links to or screenshots of your app or website. We’ll review your request and hopefully find a way to help your project succeed!

#### How much does it cost to use the Yelp API? Is there a fee if I need more than 25,000 calls per day?

The API is open and free for default access , with additional rate limit volumes provided case-by-case. Please email api@yelp.com for more information if you’re expecting higher volumes!

#### Can I cache data from the API?

Yes, although with great power comes great responsibility. You may cache Yelp API content for up a maximum of 24 hours. Business ids can be stored indefinitely.

#### Can I use the Yelp API for academic research?

For years, we’ve provided access to a subset of rich Yelp content through our academic dataset. Jump in and participate in our [Dataset Challenge](https://www.yelp.com/dataset_challenge) if you’re up to the task! Please also feel free to reach out to api@yelp.com if you have an interesting research project in mind. We’d love to hear from you.

#### What locales does the API support?

The Yelp API supports 42 locales using the locale parameter. [Here](../api-references/supported-locales.md) is the list of supported locales.

#### What will happen to API 2.0?

There is no concrete plan yet.

## Functionality questions

#### Can the API return information for any business on Yelp?

The API only includes information for reviewed businesses. With millions of great local businesses on Yelp, though, you won’t be without options!

#### How can I get access to full review text?

The Yelp API does not return full review text. Three review excerpts of 160 characters are provided by default.

#### Can I change which reviews are returned for an API query?

In order to maintain a consistent Yelp experience across all platforms, the Yelp API uses a variation of factors to determine and return a business’s top review excerpts. The sort order is determined by recency, user voting, and other review quality factors to help consumers make informed decisions. The Yelp API cannot be configured to return alternative or hand-picked review excerpts.

#### Can I get coordinates of a business through the API?

Yes, the large majority of businesses returned by our API will have coordinates (latitude and longitude).

#### How do I filter by country?

The Yelp API returns results from all geographies where Yelp is available. To filter results to a specific city, make sure you use the location parameter when using [search](../api-references/businesses-search.md) API.

#### What can I do with transaction search API? What kinds of businesses are currently supported?

We currently return all US-based businesses on Yelp which support food delivery through Yelp Eat24 and partners like ChowNow, EatStreet, and Delivery.com.

#### What’s the best way to match a specific business?

[Phone search](../api-references/businesses-search-phone.md) API matches a phone number to a list of businesses based Yelp data. You can also use [autocomplete](.../api-references/autocomplete.md) API to provide suggestions for businesses, keywords and categories.

#### Where can I get high resolution versions of the Yelp stars and logos?

[Yelp API Display Requirements](https://www.yelp.com/developers/display_requirements) is your friend.
