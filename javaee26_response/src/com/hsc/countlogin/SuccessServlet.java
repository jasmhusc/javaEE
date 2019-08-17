package com.hsc.countlogin;

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

        // 用于执行成功登录事件
        // 成功输出欢迎语句
        int count = (int) getServletContext().getAttribute("count");
        response.getWriter().write("欢迎光临，您是第" + count + "个登录成功的用户！");
    }
}
