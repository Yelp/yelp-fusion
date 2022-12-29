package io.github.stewseo.examples;

import io.github.stewseo.client.yelpfusion.YelpFusionAsyncClient;
import io.github.stewseo.temporaldata.TemporalDataInterface;

public interface YelpFusionService {

    YelpFusionAsyncClient yelpFusionClient(String apiKey);

    TemporalDataInterface temporalDataService();

}
