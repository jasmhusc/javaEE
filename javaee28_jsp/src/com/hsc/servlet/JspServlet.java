package com.hsc.servlet;

import com.hsc.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "JspServlet", urlPatterns = "/JspServlet")
public class JspServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 用于演示jsp的使用
        // 1.request域对象
        request.setAttribute("name", "request域");
        // 2.servletContext域对象
        ServletContext application = request.getServletContext();
        application.setAttribute("name", new User("马云", 45, Date.valueOf("1979-09-23")));
        // 3.session域对象
        HttpSession session = request.getSession();
        session.setAttribute("name", new User("柳岩", 18, Date.valueOf("1988-05-17")));

        // 转发跳转到：elDemo.jsp，后者获取域对象数据
        request.getRequestDispatcher("el/elDemo1.jsp").forward(request, response);
    }
}
