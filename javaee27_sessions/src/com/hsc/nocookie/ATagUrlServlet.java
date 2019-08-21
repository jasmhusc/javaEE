package com.hsc.nocookie;

import com.hsc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ATagUrlServlet", urlPatterns = "/ATagUrlServlet")
public class ATagUrlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // a标签的url重写
        response.setContentType("text/html;charset=utf-8");
        request.getSession().setAttribute("student", new User("范冰冰", "美女"));
//        response.getWriter().write("<a href='DecodUrlServlet'>点击跳转</a>"); 不行
        /**
         * 普通a标签和重定向跳转都不行，原因是cookie被禁用，服务器每次都会发送新的SESSIONID的cookie，
         * 浏览器却不会携带cookie过来，每次都是新的session，数据存储后无法取出。
         */
        response.getWriter().write("<a href='" + response.encodeRedirectURL("DecodUrlServlet") + "'>点击跳转</a>");
    }
}
