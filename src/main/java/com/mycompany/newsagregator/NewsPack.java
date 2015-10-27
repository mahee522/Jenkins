package com.mycompany.newsagregator;

import javax.servlet.http.HttpSession;

public class NewsPack {

    News news;
    HttpSession session;

    public NewsPack(HttpSession session, News news) {
        this.news = news;
        this.session = session;
    }
    
    /*Данный метод предназначен для получения следующей порции новостей для отправки.
    Возвращается объект класса News, с колличеством новостей, прописанном в NewsConfig.
    После этого он запоминает последнюю позицию и при следующем обращении начинает с нее.
    Если в изначальном объекте News заканчиваются элементы, то мы перемещаемся в 
    начало списка новостей и продолжаем выводить элементы.*/
    public News next() {

        Integer beginPos = (Integer) session.getAttribute("pointer");
        if (beginPos == null) {
            beginPos = 0;
        }
        NewsConfig config = new NewsConfig();
        Integer packSize = config.getSize();
        Integer endPos = beginPos + packSize;
        News pack = new News();

        if (endPos > news.getAll().size()) {
            for (int i = beginPos; i < news.getAll().size(); i++) {
                pack.add(news.get(i));
            }
            beginPos = 0;
            endPos = endPos - news.getAll().size();
        }

        for (int i = beginPos; i < endPos && i < news.getAll().size(); i++) {
            pack.add(news.get(i));
        }
        session.setAttribute("pointer", endPos);
        return pack;
    }
}
