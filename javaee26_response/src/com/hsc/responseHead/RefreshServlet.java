package com.hsc.responseHead;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RefreshServlet", urlPatterns = "/RefreshServlet")
public class RefreshServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 实现3秒后定时重定向跳转页面
        String filename = "/ServletContext3";
        String contextPath = request.getContextPath();
        response.setHeader("refresh", "3;url=" + contextPath + filename);

        /*
         以上代码没有3秒倒计时显示，此处直接跳转到一个显示时间的页面，3秒后依然会跳转到上面的页面
         这里只能用转发跳转，否则重定向后response就销毁了，以上设置就失效了。
         */
        request.getRequestDispatcher("/refresh.html").forward(request, response);
        //服务器内部跳转第一个“/”代表当前项目内
    }
}
