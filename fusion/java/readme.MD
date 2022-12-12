### Yelp Fusion Java Client Sample
#### Overview
Examples.java uses the result from an Autocomplete Request as the required param for a Categories Alias Request. 
The parent category is used to Search Businesses and store Business Details in a List.  

### [More Examples](https://stewseo.github.io/yelp-fusion-client/examples)
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
