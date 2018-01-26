package com.m.taskman.models.com.m.models;

import com.m.taskman.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kadan on 1/26/18.
 */

public class DorisService {
    private  static OkHttpClient client = new OkHttpClient();

    public static void getConnection(String url, Callback callback) {
//

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    public String getAPIKey(Response response) {
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject yelpJSON = new JSONObject(jsonData);
                String ApiKey = yelpJSON.getJSONObject("DRS_Success").getString("message");
                return ApiKey;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void authenticateUser(String username, String password, Callback callback) {
        String credential = Credentials.basic(username, password);

        Request request = new Request.Builder()
                .url(Constants.GET_KEY_URL)
                .header("Authorization", credential)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
