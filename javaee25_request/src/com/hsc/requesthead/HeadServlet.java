package com.hsc.requesthead;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "HeadServlet", urlPatterns = "/HeadServlet")
public class HeadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 获取请求头的数据：
         * request获取请求头api方法
         * 1. request.getHeader(String name) 根据请求头的名字获取对应的值
         * 2. request.getHeaderNames() 根据请求头的名字列表集合
         * */
        //1.获取所有请求头的名字列表
        Enumeration<String> names = request.getHeaderNames();
        //2.循环遍历打印每一对请求头的键与值
        while (names.hasMoreElements()) {
            //获取每一个元素（请求头的名字）
            String element = names.nextElement();
            // 根据键获取值
            String name = request.getHeader(element);
            System.out.println(element + "===" + name);
        }
    }
}
