package com.hsc.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckUsernameServlet", urlPatterns = "/userexist")
public class CheckUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取username的数据
        String username = request.getParameter("username");
        // 这里只是简单判断用户名是否为：newName
        if ("newName".equalsIgnoreCase(username))
            response.getWriter().write("false");
        else
            response.getWriter().write("true");
    }
}
