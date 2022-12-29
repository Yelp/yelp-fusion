package io.github.stewseo.examples;

import com.brein.domain.results.temporaldataparts.BreinLocationResult;
import io.github.stewseo.client.yelpfusion.YelpFusionAsyncClient;
import io.github.stewseo.client.yelpfusion.events.Event;
import io.github.stewseo.client.yelpfusion.events.EventSearchRequest;
import io.github.stewseo.client.yelpfusion.events.EventSearchResponse;
import io.github.stewseo.temporaldata.TemporalDataInterface;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

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
