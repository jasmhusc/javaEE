package com.hsc.nocookie;

import com.hsc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DecodUrlServlet", urlPatterns = "/DecodUrlServlet")
public class DecodUrlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取数据
        response.setContentType("text/html;charset=utf-8");
        User ly = (User) request.getSession().getAttribute("student");
        response.getWriter().write(ly.getUsername());
    }
}
