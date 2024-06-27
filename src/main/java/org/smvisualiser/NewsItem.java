package org.smvisualiser;

public class NewsItem {

  private final String publisher;
  private final String author;
  private final String title;
  private final String description;
  private final String url;
  private final String imageUrl;
  private final String date;
  private final String body;

  public NewsItem(String publisher, String author, String title, String description, String url, String imageUrl, String date, String body) {
    this.publisher = publisher;
    this.author = author;
    this.title = title;
    this.description = description;
    this.url = url;
    this.imageUrl = imageUrl;
    this.date = date;
    this.body = body;
  }

  public String getPublisher() {
    return publisher;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getUrl() {
    return url;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getDate() {
    return date;
  }

  public String getBody() {
    return body;
  }
}
