package com.hsc.responseHead;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ContentDispositionServlet1", urlPatterns = "/ContentDispositionServlet1")
public class ContentDispositionServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //目标：读取一个资源文件图片输出给浏览器，浏览器采用附件下载
        // 文件名没有中文和特殊字符，这里设置为mn1.jpg
        response.setHeader("Content-Disposition", "attachment;filename=mn1.jpg");

        // 读取操作
        ServletContext application = getServletContext();
        InputStream in = application.getResourceAsStream("/img/250.jpg");
        ServletOutputStream out = response.getOutputStream();
        // IO工具类
        IOUtils.copy(in, out);
        in.close();
    }
}
