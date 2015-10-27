package com.mycompany.newsagregator;

import com.mycompany.newsagregator.Algorithms.SimleAlgorithm;
import com.mycompany.newsagregator.io.readers.HttpNewsReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class HelloServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) {
        NewsConfig newsConfig = new NewsConfig();
        newsConfig.setAlgorithm(new SimleAlgorithm());
        newsConfig.setSize(3);
        HttpNewsReader reader = new HttpNewsReader();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParserConfigurationException, SAXException {
        response.setContentType("text/html;charset=UTF-8");
        NewsConfig config = new NewsConfig();
        NewsWorker newsWorker = new NewsWorker(config);
        News news = newsWorker.getNews();
        NewsPack pack = new NewsPack(request.getSession(), news);
        newsWorker.sendNews(response, pack.next());
        response.getWriter("Hello Worlf");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HelloServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(HelloServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(HelloServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(HelloServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
