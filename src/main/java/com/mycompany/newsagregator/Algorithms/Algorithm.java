package com.mycompany.newsagregator.Algorithms;

import com.mycompany.newsagregator.Item;
import com.mycompany.newsagregator.News;

public interface Algorithm {

    public void init(News news);
    public Item next();
    public boolean hasNext();
}
