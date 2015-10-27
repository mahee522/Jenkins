package com.mycompany.newsagregator.io.readers;

import com.mycompany.newsagregator.Item;
import com.mycompany.newsagregator.News;
import com.mycompany.newsagregator.Parsers.XmlParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class FolderNewsReader implements NewsReader {

    private Item getDescription(String path, Item item) throws IOException, ParserConfigurationException, SAXException {

        XmlParser parser = new XmlParser();
        File folder = new File(path);
        File[] fList = folder.listFiles();

        FileInputStream fin = null;

        for (File file : fList) {
            if (file.isFile() && file.getName().substring(file.getName().length() - 3).equals("xml")) {
                try {
                    fin = new FileInputStream(path + "\\" + file.getName());
                    item = parser.parse(fin).get(0);
                } finally {
                    fin.close();
                }
            }
        }

        return item;
    }

    private boolean isImage(File file) {
        String name = file.getName();
        Integer posit = name.lastIndexOf(".") + 1;
        String extention = file.getName().substring(posit);
        return extention.equals("jpg") || extention.equals("png") || extention.equals("jpeg");
    }

    private Item getImages(String path, Item item) {
        File folder = new File(path);
        File[] fList = folder.listFiles();

        for (File file : fList) {
            if (file.isFile() && isImage(file)) {
                if (item == null) {
                    item = new Item();
                }
                item.addImage(path + "\\" + file.getName());
            }
        }
        return item;
    }

    public News read(String path) throws ParserConfigurationException, SAXException, IOException, FileNotFoundException {
        File F = new File(path);
        News news = null;
        Item item = null;
        if (F.isDirectory()) {
            item = getDescription(path, item);
            item = getImages(path, item);
            if (item != null) {
                news = new News();
                news.add(item);
            }
        }
        return news;

    }

}
