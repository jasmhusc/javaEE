package com.hsc.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 解决乱码
        response.setContentType("text/html;charset=utf-8");
        // 注销当前登录的账户
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);
//        session.invalidate();
        response.getWriter().write("<a href='login.html'>请登录</a>");
    }
}
