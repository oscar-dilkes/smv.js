package org.smvisualiser;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jfree.data.json.impl.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NewsClient {


  private static final String BASE_URL = "https://newsapi.org/v2/everything";
  private final String API_KEY;
  private final OkHttpClient httpClient;
  private final Gson gson;

  public NewsClient() {
    this.httpClient = new OkHttpClient();
    this.gson = new Gson();
    this.API_KEY = retrieveKey();
  }

  private static String retrieveKey() {
    try {
      return Files.readString(Paths.get("news_api_key")).trim();
    } catch (IOException e) {
      return null;
    }
  }

  public JsonObject newsRetriever(String symbol) {
    String url = String.format("%s?q=%s&apiKey=%s", BASE_URL, symbol, API_KEY);

    Request request = new Request.Builder()
            .url(url)
            .build();

    try (Response response = httpClient.newCall(request).execute()) {
      if (!response.isSuccessful()) {
        return null;
      }

      String responseBody = response.body().string();
      JsonObject data = gson.fromJson(responseBody, JsonObject.class);
      return data;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
