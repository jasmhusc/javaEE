package com.hsc.web;

import com.hsc.entity.User;
import com.hsc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 首先校验验证码
        String verifycode = request.getParameter("verifycode");
        if (verifycode.length() == 0) {
            // 验证码为空
            request.setAttribute("errorMsg", "请输入验证码！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        String checkCode = (String) request.getSession().getAttribute("Server_CheckCode");
        if (!checkCode.equalsIgnoreCase(verifycode)) {
            // 验证码不正确
            request.setAttribute("errorMsg", "验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        // 用户登录，并实现自动登录。
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        String autoLogin = request.getParameter("auto_login");
        // 查询数据库，判断用户登录是否成功
        User loginUser = service.login(username, password);
        if (loginUser != null) {
            // 成功
            // 1.是否勾选自动登录,on
            if ("on".equals(autoLogin)) {
                Cookie auto_login = new Cookie("auto_login", username + "#" + password);
                auto_login.setMaxAge(180);
                //auto_login.setPath("/index.jsp");
                response.addCookie(auto_login);
            }
            // 2.存储session
            request.getSession().setAttribute("user", loginUser);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            // 登录失败
            request.setAttribute("errorMsg", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
