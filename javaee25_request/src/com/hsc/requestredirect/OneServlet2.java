package com.hsc.requestredirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OneServlet2", urlPatterns = "/OneServlet2")
public class OneServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
         请求重定向跳转
         1.直接响应请求，告诉浏览器访问重定向的地址
         2.不需要传数据，不共享request和response
         3.response的方法
         4.可以访问外网
         */
        //目标：实现从OneServlet2重定向跳转到TwoServlet2
        //  重定向url="/资源部署目录名字/资源路径"
        //  "/资源部署目录名字"获取语法：request.getContextPath();
//        response.sendRedirect(request.getContextPath()+"/TwoServlet2");
        // 跳转到外网
        response.sendRedirect("https://www.baidu.com");
    }
}
