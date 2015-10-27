package com.mycompany.newsagregator.Algorithms;

import com.mycompany.newsagregator.Item;
import com.mycompany.newsagregator.News;
import java.util.Iterator;

public class SimleAlgorithm implements Algorithm {

    News news = null;
    Iterator iterator = null;

    public void init(News news) {
        this.news = news;
        iterator = news.getAll().iterator();
    }

    public Item next() {
        return (Item) iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}
