package com.mycompany.newsagregator.Parsers;

import com.mycompany.newsagregator.Item;
import com.mycompany.newsagregator.News;
import java.io.IOException;
import java.io.InputStream;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {

    private Item createItem(Element element) {
        Item item = new Item();
        item.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
        item.setDescription(element.getElementsByTagName("description").item(0).getTextContent());
        item.setAuthor(element.getElementsByTagName("author").item(0).getTextContent());
        item.setPubDate(element.getElementsByTagName("pubDate").item(0).getTextContent());
        item.setLink(element.getElementsByTagName("link").item(0).getTextContent());
        return item;
    }
    
    private Document createDocument(InputStream input) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilder xml = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = xml.parse(input);
        return doc;
    }
    
    public News parse(InputStream input) throws ParserConfigurationException, SAXException, IOException {
        News news = new News();
        Element rootel = createDocument(input).getDocumentElement();
        NodeList channelNodes = rootel.getElementsByTagName("item");

        for (int j = 0; j < channelNodes.getLength(); j++) {
            Element element = (Element) channelNodes.item(j);
            Item item = createItem(element);
            news.add(item);
        }

        return news;
    }
}
