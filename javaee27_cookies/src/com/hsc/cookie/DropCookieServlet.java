package com.hsc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DropCookieServlet", urlPatterns = "/DropCookieServlet")
public class DropCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 删除cookie，直接创建键一样的cookie，设置有效时间为0或负数，让其马上失效。
        Cookie cookie = new Cookie("age", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
