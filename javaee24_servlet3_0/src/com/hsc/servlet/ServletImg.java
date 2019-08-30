package com.hsc.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ServletImg", urlPatterns = "/ServletImg")
public class ServletImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取字节输出流，文件输入流
        ServletOutputStream out = response.getOutputStream();
        String path = getServletContext().getRealPath("img/mn.png");
        FileInputStream in = new FileInputStream(path);

        // 读取图片输出
        byte[] bytes = new byte[8192];
        int len;
        while ((len = in.read(bytes)) != -1){
            out.write(bytes,0,len);
        }

        // 关流
        in.close();
        out.close();
    }
}
