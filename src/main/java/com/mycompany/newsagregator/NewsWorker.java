package com.mycompany.newsagregator;

import com.mycompany.newsagregator.Algorithms.Algorithm;
import com.mycompany.newsagregator.io.readers.FolderNewsReader;
import com.mycompany.newsagregator.io.writers.HttpNewsWriter;
import com.mycompany.newsagregator.io.writers.NewsWriter;
import com.mycompany.newsagregator.io.readers.HttpNewsReader;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class NewsWorker {

    private NewsConfig config;

    public NewsWorker(NewsConfig config) {
        this.config = config;
    }

    private News buildNews(News news) {
        Algorithm algorithm = this.config.getAlgorithm();
        News buildedNews = new News();
        algorithm.init(news);
        while (algorithm.hasNext()) {
            buildedNews.add(algorithm.next());
        }
        return buildedNews;
    }

    private News setNewsSources(News news, String source) {
        for (Item i : news.getAll()) {
            i.setNewsSource(source);
        }
        return news;
    }

    public News getNews() throws IOException, ParserConfigurationException, SAXException {
        News news = new News();
        News rss = new News();
        News folder = new News();
        ArrayList<String> links = this.config.getLinks();
        ArrayList<String> folders = this.config.getFolders();
        HttpNewsReader httpReader = new HttpNewsReader();
        FolderNewsReader folderReader = new FolderNewsReader();
        for (String s : links) {
            News readedNews = httpReader.read(s);
            if (readedNews != null) {
                rss.addNews(readedNews);
                setNewsSources(rss, "RSS");
            }
        }
        for (String s : folders) {
            News readedNews = folderReader.read(s);
            if (readedNews != null) {
                folder.addNews(readedNews);
                setNewsSources(folder, "Folder");
            }
        }
        news.addNews(rss);
        news.addNews(folder);

        return news;
    }

    public void sendNews(HttpServletResponse response, News news) throws IOException {
        NewsWriter writer = new HttpNewsWriter();
        News buildedNews = buildNews(news);
        writer.write(response, buildedNews);
    }

    public void setConfig(NewsConfig config) {
        this.config = config;
    }

}
