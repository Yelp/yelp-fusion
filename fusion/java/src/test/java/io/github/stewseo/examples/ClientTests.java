package io.github.stewseo.examples;

import com.brein.domain.results.BreinTemporalDataResult;
import com.brein.domain.results.temporaldataparts.BreinLocationResult;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.stewseo.client.json.jackson.JacksonJsonpMapper;
import io.github.stewseo.client.transport.YelpFusionTransport;
import io.github.stewseo.client.transport.restclient.YelpRestClientTransport;
import io.github.stewseo.client.yelpfusion.YelpFusionAsyncClient;
import io.github.stewseo.client.yelpfusion.YelpFusionSyncBlockingClient;
import io.github.stewseo.client.yelpfusion.business.search.SearchBusinessResponse;
import io.github.stewseo.client.yelpfusion.events.Event;
import io.github.stewseo.client.yelpfusion.events.EventSearchRequest;
import io.github.stewseo.client.yelpfusion.events.EventSearchResponse;
import io.github.stewseo.lowlevel.restclient.RestClient;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ClientTests {

    @Test
    public void createAllComponentsTest() throws IOException {

        HttpHost httpHost = new HttpHost("api.yelp.com", 443, "https");

        // create the rest client with http host
        RestClient restClient = RestClient.builder(httpHost)
                .setDefaultHeaders(new Header[]{new BasicHeader("Authorization", "Bearer " + System.getenv("YELP_API_KEY"))}).build();

        JacksonJsonpMapper mapper = new JacksonJsonpMapper();

        // Create transport with a Json object mapper and the rest client
        YelpFusionTransport transport = new YelpRestClientTransport(restClient, mapper);

        // Create the yelp fusion client
        YelpFusionSyncBlockingClient client = new YelpFusionSyncBlockingClient(transport);

        // Build a Business Search Request
    }

    @Test
    public void createYelpFusionClientTest() throws Exception {

        // Create a synchronized blocking yelp fusion client and build a Business Search Request
        SearchBusinessResponse response = YelpFusionSyncBlockingClient.createClient(System.getenv("YELP_API_KEY")).businesses().businessSearch(s -> s
                .location("nyc")
                .term("restaurants")
                .categories(cat -> cat
                        .alias("pizza"))
                .open_now(true)
                .limit(50)
                .offset(0)
                .sort_by("review_count"));
    }

    @Test
    public void yelpFusionAsyncClientTest() throws Exception {

        // Create an Async-blocking yelp fusion client and build a Business Search Request
        CompletableFuture<SearchBusinessResponse> response = YelpFusionAsyncClient.createAsyncClient(System.getenv("YELP_API_KEY")).businesses().search(s -> s
                .location(List.of("nyc"))
                .term("restaurants")
                .categories(cat -> cat
                        .alias("pizza"))
                .open_now(true)
                .limit(50)
                .offset(0)
                .sort_by("review_count"), ObjectNode.class);
    }
}