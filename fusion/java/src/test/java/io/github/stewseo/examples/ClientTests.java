package io.github.stewseo.examples;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.stewseo.lowlevel.restclient.RestClient;
import io.github.stewseo.yelp.fusion.client.json.jackson.JacksonJsonpMapper;
import io.github.stewseo.yelp.fusion.client.transport.YelpFusionTransport;
import io.github.stewseo.yelp.fusion.client.transport.restclient.YelpRestClientTransport;
import io.github.stewseo.yelp.fusion.client.yelpfusion.YelpFusionAsyncClient;
import io.github.stewseo.yelp.fusion.client.yelpfusion.YelpFusionClient;
import io.github.stewseo.yelp.fusion.client.yelpfusion.business.search.SearchBusinessResponse;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
        YelpFusionClient client = new YelpFusionClient(transport);

        // Build a Business Search Request
    }

    @Test
    public void createYelpFusionClientTest() throws Exception {

        // Create a synchronized blocking yelp fusion client and build a Business Search Request
        SearchBusinessResponse response = YelpFusionClient.createClient(System.getenv("YELP_API_KEY")).businesses().businessSearch(s -> s
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