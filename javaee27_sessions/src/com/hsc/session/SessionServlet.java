package com.hsc.session;

import com.hsc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SessionServlet", urlPatterns = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
         session的生命受制于浏览器和服务器的双重限制：
         1. 浏览器关闭，cookie失效，从而JSESSIONID也无法再发挥作用，session结束；
         2. 服务器的时间设置，默认为30分钟。
         这样，旧session存储的数据也将不能使用。
         本servlet实现浏览器关闭，session内数据依然可以使用。
         */
        // 1.存储数据
        HttpSession session = request.getSession();
        session.setAttribute("student", new User("柳岩", "性感美女"));
        // 2.将session的JSESSIONID的cookie的时间设置更改，让其不会如默认情况下一样，浏览器关闭旧消失。
        String sessionId = session.getId();
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setMaxAge(60 * 30);// 30分钟
        response.addCookie(cookie);
    }
}
