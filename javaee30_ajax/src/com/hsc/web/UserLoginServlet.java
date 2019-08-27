package com.hsc.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/userlogin")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 简单判断
        if ("admin".equals(username) && "123".equals(password))
            response.getWriter().write("登录成功！");
        else {
            response.getWriter().write("登录失败！");
//            response.sendRedirect("https://www.baidu.com/"); 没有任何反应
        }
    }
}
