package com.hsc.responseHead;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LocationServlet", urlPatterns = "/LocationServlet")
public class LocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置状态码为302，代表重定向跳转(不能单独使用，必须与响应头设置一起使用)
        response.setStatus(303);
        //设置响应头location实现进行重定向跳转页面(响应头的名字不区分大小写)
        response.setHeader("Location", request.getContextPath() + "/ServletContext3");

        //注意：上面就是实现页面重定向跳转的原理代码，推荐使用封装代码：response.sendRedirect(url)；
    }
}
