package com.hsc.servletcontext;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@WebServlet(name = "ServletContext3", urlPatterns = "/ServletContext3")
public class ServletContext3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 路径3：类路径（适合src目录）
         * url1 = file:/F:/idea/javaEE/out/artifacts/javaee26_response_war_exploded/WEB-INF/classes/com/hsc/servletcontext/
         *      这个回去web目录太长了！
         * url2 = file:/F:/idea/javaEE/out/artifacts/javaee26_response_war_exploded/WEB-INF/classes/
         *      这个回去两级可以回到web目录
         */
        // 查看路径
        URL url1 = ServletContext3.class.getResource("");
        System.out.println("url1 = " + url1);
        URL url2 = this.getClass().getClassLoader().getResource("");
        System.out.println("url2 = " + url2);

        // 用IO工具类操作
        // 输入输出流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("../../img/250.jpg");
//        InputStream in = ServletContext3.class.getResourceAsStream("../../img/250.jpg"); 不行
        ServletOutputStream out = response.getOutputStream();
        // IO工具类完成读取和输出
        IOUtils.copy(in, out);
        // 关流
        in.close();
    }
}
