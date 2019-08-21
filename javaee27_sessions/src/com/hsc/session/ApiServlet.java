package com.hsc.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApiServlet", urlPatterns = "/ApiServlet")
public class ApiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // session介绍，输出相关的信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 1.获取session
        HttpSession session = request.getSession();

        // 2.获取session的ID
        String id = session.getId();
        out.write("session的ID = " + id + "<br/><hr/>");
        // 3.获取session的创建时间
        out.write("会话创建时间 = " + session.getCreationTime() + "<br/><hr/>");
        // 4.获取上次访问的时间
        out.write("上次访问的时间 = " + session.getLastAccessedTime() + "<br/><hr/>");
        // 5.获取是否是新的会话
        out.write("是否是新的会话 = " + session.isNew() + "<br/><hr/>");
        // 6.获取上下文对象
        out.write("上下文对象 = " + session.getServletContext() + "<br/><hr/>");
    }
}
