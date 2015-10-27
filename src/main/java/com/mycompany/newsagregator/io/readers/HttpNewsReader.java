package com.mycompany.newsagregator.io.readers;

import com.mycompany.newsagregator.Item;
import com.mycompany.newsagregator.News;
import com.mycompany.newsagregator.Parsers.XmlParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class HttpNewsReader implements NewsReader {

    public News read(String link) throws MalformedURLException, ParserConfigurationException, SAXException, IOException {

        News news = new News();
        InputStream stream = null;
        try {
            URL url;
            url = new URL(link);
            XmlParser parser = new XmlParser();
            HttpURLConnection con = null;
            con = (HttpURLConnection) url.openConnection();
            stream = con.getInputStream();
            news = parser.parse(stream);
        } finally {
            stream.close();
        }
        return news;
    }
}
