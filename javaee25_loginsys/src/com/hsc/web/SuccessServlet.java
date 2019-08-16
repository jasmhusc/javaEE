package com.hsc.web;

import com.hsc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SuccessServlet", urlPatterns = "/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 此servlet执行成功登录的响应，这里直接写出xxx成功登录
        User loginUser = (User) request.getAttribute("loginUser");
        response.setContentType("text/html;charset=utf8");
        response.getWriter().write("恭喜，" + loginUser.getUsername() + "登录成功！");
    }
}
