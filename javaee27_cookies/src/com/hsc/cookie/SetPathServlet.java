package com.hsc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetPathServlet", urlPatterns = "/SetPathServlet")
public class SetPathServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置有效路径
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("cookiepath".equals(cookie.getName()))
                response.getWriter().write("cookiepath = " + cookie.getValue());
        }

        // 添加cookie，并设置有效路径，只有有效路径才会携带cookie
        Cookie cookie = new Cookie("cookiepath", "onlypath");

        //设置有效路径
//        cookie.setPath(request.getContextPath()+"/SetPathServlet");
        cookie.setPath("/SetPathServlet");
        response.addCookie(cookie);
    }
}
