package com.hsc.countlogin;

import javax.servlet.ServletConfig;
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

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 设置一个记录登录人数的count属性参数，作用域为一个servlet，只在servlet初始化时执行一次。
        getServletContext().setAttribute("count", 0);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 实现登录，用户名：admin，密码：123456
        // 1.解决乱码
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf8");

        // 2.获取表单提交的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 3.判断是否登录成功
        if ("admin".equals(username) && "123456".equals(password)) {
            // 成功设置count加1，转发跳转
            int count = (int) getServletContext().getAttribute("count");
            getServletContext().setAttribute("count", ++count);
            request.getRequestDispatcher("/SuccessServlet").forward(request, response);
        } else {
            // 失败输出登录失败
            response.getWriter().write("登录失败！");
        }
    }
}
