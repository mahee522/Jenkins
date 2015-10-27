package com.mycompany.newsagregator.io.readers;

import com.mycompany.newsagregator.News;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public interface NewsReader {

    News read(String url) throws MalformedURLException, ParserConfigurationException, SAXException, IOException,FileNotFoundException;
}
