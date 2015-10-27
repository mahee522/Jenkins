package com.mycompany.newsagregator.io.writers;

import com.mycompany.newsagregator.News;
import com.mycompany.newsagregator.converters.ToJsonConverter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class HttpNewsWriter implements NewsWriter {

    public void write(HttpServletResponse response, News news) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            out.println(ToJsonConverter.convert(news));
        } finally {
            out.close();
        }

    }
}
