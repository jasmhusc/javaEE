package com.hsc.responseHead;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

@WebServlet(name = "ContentEncodingServlet", urlPatterns = "/ContentEncodingServlet")
public class ContentEncodingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //目标：输出一个大量的文本字符串，对其使用gzip压缩，输出给浏览器，浏览器解压显示

        // 模拟包含许多重复字符串的文本文件，拼接大量abc
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            sb.append("abc");
        }
        // 将字符串转换为字节数组，查看字节数
        byte[] bytes = sb.toString().getBytes();
        System.out.println("压缩前字节数 = " + bytes.length); // 1500
        // 压缩写出到内存
        response.setHeader("Content-Encoding", "gzip"); // 34
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(response.getOutputStream());
        gzipOutputStream.write(bytes);
        // 将内存数据写出
        gzipOutputStream.finish();
    }
}
