package com.mycompany.newsagregator;

import java.util.ArrayList;

public class News {

    private ArrayList<Item> news = new ArrayList<Item>();

    public Item get(Integer numb) {
        return news.get(numb);
    }

    public ArrayList<Item> getAll() {
        return news;
    }

    public void add(Item item) {
            news.add(item);
    }

    public void addNews(News news) {
            this.news.addAll(news.getAll());
    }

}
