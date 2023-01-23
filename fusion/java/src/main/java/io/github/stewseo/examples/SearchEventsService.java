package io.github.stewseo.examples;

import com.brein.domain.results.temporaldataparts.BreinLocationResult;
import io.github.stewseo.client.yelpfusion.YelpFusionAsyncClient;
import io.github.stewseo.client.yelpfusion.events.Event;
import io.github.stewseo.client.yelpfusion.events.EventSearchRequest;
import io.github.stewseo.client.yelpfusion.events.EventSearchResponse;
import io.github.stewseo.temporaldata.TemporalDataInterface;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class SearchEventsService {

    private static YelpFusionServiceExample serviceExample;

    private static YelpFusionAsyncClient yelpFusionAsyncClient;

    private static TemporalDataInterface temporalDataService;
    private static final int maxRadius = 40000, limit = 50;

    public SearchEventsService() {
        createSearchEventsService();
    }

    public void createSearchEventsService() {

        String apiKey = System.getenv("YELP_API_KEY");

        serviceExample = new YelpFusionServiceExample();

        yelpFusionAsyncClient = serviceExample.yelpFusionClient(apiKey);

        temporalDataService = serviceExample.temporalDataService();
    }

    public static EventSearchRequest buildEventSearchRequest(String city) {
        return EventSearchRequest.of(e -> e
                .location(city)
                .radius(maxRadius)
                .limit(limit)
        );
    }

    public static EventSearchRequest buildEventSearchRequest(BreinLocationResult breinLocResult) {
        // Map<String, Map<String, Object>> geoJsons = breinLocationResult.getGeoJsons();
        return EventSearchRequest.of(e -> e
                .longitude(breinLocResult.getLon())
                .latitude(breinLocResult.getLat())
                .limit(limit)
                .radius(maxRadius));
    }

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

    protected Stream<BreinLocationResult> getStreamOfTemporalData() {

        final Stream<String> citiesInCa =
                Stream.of("San Francisco", "Oakland", "San Jose", "Monterey", "Napa", "Sonoma", "Los Angeles","Carmel By The Sea", "San Diego", "Santa Barbara");

        final Stream<String> cities = Stream.of("NYC", "Las Vegas", "Honolulu", "Phoenix", "San Antonio", "Dallas", "Chicago", "Portland", "Minneapolis", "Seattle", "New Orleans", "Boston", "Philadelphia", "Miami");

        return Stream.concat(cities, citiesInCa).map(SearchEventsService::locationByCity);
    }

    private static BreinLocationResult locationByCity(String city) {

        return temporalDataService.temporalDataResult(city).getLocation();

    }
}
