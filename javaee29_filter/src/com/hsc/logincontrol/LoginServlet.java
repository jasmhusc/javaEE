package com.hsc.logincontrol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 模拟登录
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        // 判断是否正确
        if ("admin".equals(user) && "123".equals(password)) {
            User loginuser = new User(user, password);
            request.getSession().setAttribute("loginuser", loginuser);
            // 跳转
            response.sendRedirect(request.getContextPath() + "/list.jsp");
        } else {
            // 失败
            request.setAttribute("errorMsg", "用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
