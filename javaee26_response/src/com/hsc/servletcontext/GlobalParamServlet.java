package com.hsc.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "GlobalParamServlet", urlPatterns = "/GlobalParamServlet")
public class GlobalParamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // ServletContext可以在web.xml设置全局配置参数，每一个servlet都可以获取。

        //1.读取全局参数列表
        ServletContext context = getServletContext();
        Enumeration<String> names = context.getInitParameterNames();
        //2.循环遍历
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = context.getInitParameter(name);
            //3.输出值
            System.out.println(name + " = " + value);
        }
    }
}
