//
//  main.swift
//  YelpAPISample
//

import YelpAPI
import BrightFutures

// Fill in your app keys here from
// https://www.yelp.com/developers/v3/manage_app
let appId = ""
let appSecret = ""

// Search for 3 dinner restaurants
let query = YLPQuery(location: "San Francisco, CA")
query.term = "dinner"
query.limit = 3

YLPClient.authorize(withAppId: appId, secret: appSecret).flatMap { client in
  client.search(withQuery: query)
}.onSuccess { search in
  if let topBusiness = search.businesses.first {
    print("Top business: \(topBusiness.name), id: \(topBusiness.identifier)")
  } else {
    print("No businesses found")
  }
  exit(EXIT_SUCCESS)
}.onFailure { error in
  print("Search errored: \(error)")
  exit(EXIT_FAILURE)
}

dispatchMain()
