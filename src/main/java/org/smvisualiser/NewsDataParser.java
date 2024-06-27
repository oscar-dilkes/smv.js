package org.smvisualiser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class NewsDataParser {
  public static List<NewsItem> parseNewsItems(JsonObject newsData) {
    List<NewsItem> newsItems = new ArrayList<>();

    System.out.println(newsData);

    if (newsData.has("articles")) {
      JsonArray articles = newsData.getAsJsonArray("articles");

      for (JsonElement article : articles) {
        JsonObject item = article.getAsJsonObject();

        String publisher = item.has("source") ? getString(item.getAsJsonObject("source"), "name") : null;
        String author = getString(item, "author");
        String title = getString(item, "title");
        String description = getString(item, "description");
        String url = getString(item, "url");
        String imageUrl = getString(item, "urlToImage");
        String date = getString(item, "publishedAt");
        String body = getString(item, "content");


        newsItems.add(new NewsItem(publisher, author, title, description, url, imageUrl, date, body));

      }
    }
    else {
      return null;
    }
    return newsItems;
  }

  public static String getString(JsonObject jsonObject, String key) {
    JsonElement element = jsonObject.get(key);
    return (element != null && !element.isJsonNull()) ? element.getAsString() : null;
  }

}
