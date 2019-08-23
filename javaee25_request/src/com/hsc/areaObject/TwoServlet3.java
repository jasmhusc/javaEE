package com.hsc.areaObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TwoServlet3", urlPatterns = "/TwoServlet3")
public class TwoServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取域对象的数据：name,sex
        String name = (String) request.getAttribute("name");
        System.out.println("name = " + name);
        String sex = (String) request.getAttribute("sex");
        System.out.println("sex = " + sex);

        // 写到页面
        response.setContentType("text/html;charset=utf8");
        response.getWriter().write("name===" + name + "sex===" + sex);
    }
}
