import java.io.IOException;
import okhttp3.*;
import okhttp3.Request.Builder;
import org.json.*;

/**
 * Created by Junghyun Park on 2/16/17.
 * www.sean-park.github.io
 */

// using AOuth 2.0 to access Yelp Fusion api

public class sample {

    public static void main(String[] args)throws JSONException, IOException {


        // POST https://api.yelp.com/oauth2/token
        String accessToken=null;

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "client_id=NdVuXwgZodPj3IOKDHIblA&client_secret=tBf1HJybwlCMq9sQfdQjgl5SkqvCFiZQt1ZTerENg4oc6HTFJNg4cAH8TIegWxgE&grant_type=client_credentials");
        Request request = new Request.Builder()
                .url("https://api.yelp.com/oauth2/token")
                .post(body)
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "8d9de8ad-800c-50e1-fb4a-46fcb5f2f209")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        try {
            Response response = client.newCall(request).execute();

            JSONObject jsonObjectToken = new JSONObject(response.body().string().trim());

            accessToken = jsonObjectToken.getString("access_token");


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // GET /businesses/search
        OkHttpClient client2 = new OkHttpClient();


        String term = "taco";                       // term
        String location = "Irivine, CA";            // location
        String price = "1";                         // price        1 = $, 2 = $$, 3 = $$$, 4 = $$$$


        Request request2 = new Builder()
                .url("https://api.yelp.com/v3/businesses/search?term=" + term + "&location=" + location + "&limit=1&sort_by=rating&price="+price+"")
                .get()
                .addHeader("authorization", "Bearer"+" "+accessToken)
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "b5fc33ce-3dad-86d7-6e2e-d67e14e8071b")
                .build();

        try {
            Response response2 = client2.newCall(request2).execute();

            JSONObject jsonObject = new JSONObject(response2.body().string().trim());       // parser
            JSONArray myResponse = (JSONArray)jsonObject.get("businesses");
            System.out.println(myResponse.getJSONObject(0).getString("id"));


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}