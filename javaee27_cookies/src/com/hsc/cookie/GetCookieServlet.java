package com.hsc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetCookieServlet", urlPatterns = "/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取浏览器携带过来的cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            // 遍历打印cookie的键和值
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name + " = " + value);
            // 输出到浏览器显示
            response.getWriter().write(name + " = " + value);
            // JSESSIONID会存在
        }
    }
}
