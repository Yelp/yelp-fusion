### Yelp Fusion Java Client Sample
#### Overview
Examples.java uses the result from an Autocomplete Request as the required param for a Categories Alias Request. 
The parent category is used to Search Businesses and store Business Details in a List.  


```
    String apiKey = System.getenv("YELP_API_KEY");
     
        // Synchronous blocking client
        YelpFusionClient client = YelpFusionClient.createClient(apiKey);

        if (client.businessDetails(a -> a.alias("hinata-san-francisco")) != null) {
            logger.info("business exists");
        }
```

### [Dependency Configuration](https://search.maven.org/artifact/io.github.stewseo/yelp-fusion-client/1.0.52/jar)

Gradle
```
dependencies {
    implementation 'io.github.stewseo:yelp-fusion-client:1.0.52'
}
```
Maven
```
<dependency>
    <groupId>io.github.stewseo</groupId>
    <artifactId>yelp-fusion-client</artifactId>
    <version>1.0.52</version>
</dependency>
```
<br>


### Searching for events in 20 of the most populated cities in the US by latitude and longitude.

#### Using city names to get the corresponding latitude and longitude

```
   protected Stream<BreinLocationResult> getStreamOfTemporalData() {

        final Stream<String> citiesInCa =
                Stream.of("San Francisco", "Oakland", "San Jose", "Monterey", "Napa", "Sonoma", "Los Angeles","Carmel By The Sea", "San Diego", "Santa Barbara");

        final Stream<String> cities = Stream.of("NYC", "Las Vegas", "Honolulu", "Phoenix", "San Antonio", "Dallas", "Chicago", "Portland", "Minneapolis", "Seattle", "New Orleans", "Boston", "Philadelphia", "Miami");

        return Stream.concat(cities, citiesInCa).map(SearchEventsService::locationByCity);
    }

    private static BreinLocationResult locationByCity(String city) {

        return temporalDataService.temporalDataResult(city).getLocation();

    }
```

#### Build an EventSearchRequest
```
    final int limit = 50, maxRadius = 40000;
    public static EventSearchRequest buildEventSearchRequest(BreinLocationResult breinLocResult) {
        // Map<String, Map<String, Object>> geoJsons = breinLocationResult.getGeoJsons();
        return EventSearchRequest.of(e -> e
                .longitude(breinLocResult.getLon())
                .latitude(breinLocResult.getLat())
                .limit(limit)
                .radius(maxRadius));
    }
```

#### Handling failures of asynchronous tasks

```

    static List<Event> searchEvents(EventSearchRequest eventSearchRequest) {

        String requestLocation = eventSearchRequest.location();

        CompletableFuture<List<Event>> future = null;

        try {
            return yelpFusionAsyncClient.events()
                    .search(eventSearchRequest)
                    .whenComplete((response, exception) -> {

                        if (response.events() != null && !response.events().isEmpty()) {
                            System.out.println("Request city: " + requestLocation + ", Response city: " +response.events().get(0).location().city() + ", total results: " + response.total());
                        } else {
                            System.out.println("Response null " + requestLocation);
                        }
                    }).thenApplyAsync(EventSearchResponse::events)
                    .join();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    
```

#### Application

```

public class SearchEventsUsingCoordinatesExample {

    public static void main(String[] args) throws Exception {

        SearchEventsService searchEventsService = new SearchEventsService();

        final AtomicInteger count = new AtomicInteger(0);

        try(Stream<List<Event>> completableFutures = searchEventsService.getStreamOfTemporalData()
                .map(SearchEventsService::buildEventSearchRequest)
                .map(SearchEventsService::searchEvents)) {

            completableFutures.filter(Objects::nonNull).toList().forEach(event -> {
                count.getAndAdd(event.size());
            });

            System.out.println("total: " + count.get());

        }
    }

}

```

### [More Examples](https://stewseo.github.io/yelp-fusion-client/examples)
