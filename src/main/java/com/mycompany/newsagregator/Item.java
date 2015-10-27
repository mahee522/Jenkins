package com.mycompany.newsagregator;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private String title = "";
    private String description = "";
    private ArrayList<String> images = new ArrayList<String>();
    private String author = "";
    private String pubDate = "";
    private String link = "";
    private String newsSource = "";

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addAllImages(ArrayList<String> images) {
        this.images = images;
    }
    public void addImage(String image) {
        this.images.add(image);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public String getAuthor() {
        return author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getLink() {
        return link;
    }

    public String getNewsSource() {
        return newsSource;
    }

}
