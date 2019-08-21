package com.hsc.session;

import com.hsc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SessionServlet2", urlPatterns = "/SessionServlet2")
public class SessionServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 演示获取SessionServlet存储的数据
        /*
        浏览器关闭后依然可以获取之前存储的数据
        前提：必须为同一个浏览器，时间必须在浏览器的cookie消失之前，和服务器的session保存时间范围内，这里都是30分钟。
         */
        response.setContentType("text/html;charset=utf-8");
        User student = (User) request.getSession().getAttribute("student");
        response.getWriter().write(student.getUsername() + " = " + student.getPassword());
    }
}
