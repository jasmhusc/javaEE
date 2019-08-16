package com.hsc.web;

import com.hsc.entity.User;
import com.hsc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    // 进行业务逻辑需要创建业务UserService实例对象，为了节省空间，这里创建全局变量，和Servlet一起只会创建一次。
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 根据浏览器注册页面传过来的数据，执行登录业务逻辑：
         *  成功：跳转成功登录页面
         *  失败：跳转失败页面
          */
        // 1. 获取浏览器数据
        request.setCharacterEncoding("utf8");
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        // 2. 执行登录业务逻辑
        User loginUser = userService.Login(username, password);
        // 将loginUser存储进域对象，传递给SuccessServlet
        request.setAttribute("loginUser",loginUser);

        // 3. 判断是否存在该用户
        if (loginUser == null){
            // 失败跳转到本地的静态资源页面，无需传递数据，用重定向跳转。
            response.setContentType("text/html;charset=utf-8");
            response.sendRedirect(request.getContextPath() + "/failure.html");
        }else{
            // 成功，直接跳转到另一个servlet，并写出xxx成功登录，需要传递数据，用请求跳转。
            request.getRequestDispatcher("/SuccessServlet").forward(request,response);
        }
    }
}
