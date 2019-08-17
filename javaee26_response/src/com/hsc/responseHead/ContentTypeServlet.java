package com.hsc.responseHead;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContentTypeServlet", urlPatterns = "/ContentTypeServlet")
public class ContentTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 直接输出中文，浏览器显示乱码??????
//        response.getWriter().write("克里斯蒂亚诺");

        //目标：使用原理底层解决输出中文乱码
        //1.设置服务器输出字符流码表为utf8
        response.setCharacterEncoding("utf-8");
        //2.设置浏览的码表为utf8
        response.setHeader("Content-Type", "text/html;charset=utf8");
        response.getWriter().write("克里斯蒂亚诺");

        //注意：上面是原理代码，但是推荐使用response.setContentType("text/html;charset=utf-8")解决，原理就是上面2句
    }
}
