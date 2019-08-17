package com.hsc.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@WebServlet(name = "ServletContext1", urlPatterns = "/ServletContext1")
public class ServletContext1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 路径1；servletcontext适合读取web下的目录
         * url = file:/F:/idea/javaEE/out/artifacts/javaee26_response_war_exploded/
         */
        ServletContext application = getServletContext();
        // 查看默认路径
        URL url = application.getResource("");
        System.out.println("url = " + url);

        // 加载图片流
        InputStream inputStream = application.getResourceAsStream("/img/150.jpg");
        ServletOutputStream out = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        // 关流，out不用关
        inputStream.close();
    }
}
