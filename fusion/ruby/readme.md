# Yelp Fusion Code Sample for Ruby

This is a simple script to perform a search or business lookup from the command line using the Yelp Fusion API. This is written in Ruby and should be compatible with Ruby 2.2 and higher.

## Setup

Clone the repo:

```
$ git clone https://github.com/Yelp/yelp-fusion.git
```

Go into the directory:

```
$ cd yelp-fusion/fusion/ruby
```

Install the dependences:

```
$ bundle
```

Open up the `sample.rb` file and put your client_id and client_secret from the [manage app page](https://www.yelp.com/developers/v3/manage_app)

```

# Prior to December 7, 2017 the API used OAuth 2.0 to authenticate requests to the API.
# In an effort to simplify authentication, starting March 1, 2018 the API no longer uses
# OAuth 2.0 for requests and moved over to only API Keys.
```
```
# Place holders for Yelp Fusion's API_KEY.
# Grab them from https://www.yelp.com/developers/v3/manage_app
API_KEY = <YOUR_API_KEY>
```

## Usage

Once you're all setup, you should be able to run the script directly from the command line:

```
$ ruby sample.rb command [options]
```

There are two commands:

1. `search` - uses the Fusion [search endpoint](https://www.yelp.com/developers/documentation/v3/business_search) to perform a Yelp search
2. `lookup` - uses the Fusion [business endpoint](https://www.yelp.com/developers/documentation/v3/business) to look up a business based on its business id.

### Search

There are two parameters that work with search, `--term=` and `--location=`. Just like on Yelp.com's search, this is a search term to help find businesses and where you want those businesses to be located. Both are optional, term defaults to "dinner" if not provided and location defaults to "San Francisco".

Examples:

```
$ ruby sample.rb search --term=burrito --location="San Diego"
```

```
$ ruby sample.rb search --term=pizza --location="New York"
```

```
$ ruby sample.rb search --term=parks --location="London"
```

### Lookup

Lookup takes only one paramter, `--business-id`. This is the unique business id you either from the search API response or from a business page on Yelp. The id can be pulled from a Yelp biz url: `https://yelp.com/biz/<the-yelp-biz-id>`

Examples:

```
$ ruby sample.rb lookup --business-id=yelp-san-francisco
```

```
$ ruby sample.rb lookup --business-id=fox-bros-bar-b-q-atlanta
```
