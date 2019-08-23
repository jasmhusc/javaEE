package com.hsc.requestrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RowServlet", urlPatterns = "/RowServlet")
public class RowServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 获取请求行的数据并输出打印到控制台
         * 请求行：（Get/Post) + 请求的url + http协议版本
         */
        // 1. 获取提交数据的请求方法【重点】（Get/Post)
        String method = request.getMethod();
        System.out.println("method = " + method);

        // 2. 获取请求的url
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);

        // 3. 获取请求的http协议和版本号
        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);

        // 4. 获取当前servlet的访问地址
        String servletPath = request.getServletPath();// /RowServlet
        System.out.println("servletPath = " + servletPath);

        // 5. 获取当前资源部署目录的名字【重点】
        String contextPath = request.getContextPath();// /javaee25_request_war_exploded
        System.out.println("contextPath = " + contextPath);

        // 6. 获取远端的客户端的主机IP地址（默认为IPV6）
        String clientIP = request.getRemoteAddr(); //0:0:0:0:0:0:0:1(localhost)
        System.out.println("clientIP = " + clientIP);

        // 7. 获取统一资源标识符
        String requestURI = request.getRequestURI(); // /javaee25_request_war_exploded/RowServlet
        System.out.println("requestURI = " + requestURI);
    }
}
