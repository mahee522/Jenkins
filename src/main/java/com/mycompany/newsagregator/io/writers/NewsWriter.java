package com.mycompany.newsagregator.io.writers;

import com.mycompany.newsagregator.News;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public interface NewsWriter {

    void write(HttpServletResponse response, News news) throws IOException;
}
