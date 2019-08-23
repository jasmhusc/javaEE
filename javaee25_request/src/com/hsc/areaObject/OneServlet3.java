package com.hsc.areaObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OneServlet3", urlPatterns = "/OneServlet3")
public class OneServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //目标：OneServlet3存储数据，跳转到TwoServlet3
        //1.写入数据到请求域
        request.setAttribute("name", "隔壁老王");
        request.setAttribute("sex", "男");
        //2.跳转到TwoServlet3
        request.getRequestDispatcher("/TwoServlet3").forward(request, response);
    }
}
