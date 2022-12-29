package io.github.stewseo.examples;

import io.github.stewseo.client.yelpfusion.YelpFusionAsyncClient;
import io.github.stewseo.temporaldata.TemporalDataInterface;
import io.github.stewseo.temporaldata.TemporalDataService;

import java.io.IOException;

public class YelpFusionServiceExample implements YelpFusionService {

    private YelpFusionAsyncClient yelpFusionAsyncClient;

    private TemporalDataInterface temporalDataInterface;

    public YelpFusionServiceExample() {

    }

    @Override
    public YelpFusionAsyncClient yelpFusionClient(String apiKey) {
        try {
            return YelpFusionAsyncClient.createAsyncClient(apiKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TemporalDataInterface temporalDataService() {
        return new TemporalDataService();
    }
}
