package com.mycompany.newsagregator.converters;

import com.mycompany.newsagregator.Item;
import com.mycompany.newsagregator.News;
import org.json.JSONArray;
import org.json.JSONObject;

public class ToJsonConverter {

    public static JSONArray convert(News news) {

        JSONArray jsonNews = new JSONArray();
        for (Item n : news.getAll()) {
            JSONObject jsonItem = new JSONObject();
            jsonItem.put("title", n.getTitle());
            jsonItem.put("images", n.getImages());
            jsonItem.put("description", n.getDescription());
            jsonItem.put("autor", n.getAuthor());
            jsonItem.put("pubDate", n.getPubDate());
            jsonItem.put("link", n.getLink());
            JSONObject tmp = new JSONObject();
            tmp.put("item", jsonItem);
            jsonNews.put(tmp);
        }
        return jsonNews;
    }
}
