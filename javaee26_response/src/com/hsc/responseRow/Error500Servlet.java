package com.hsc.responseRow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Error500Servlet", urlPatterns = "/Error500Servlet")
public class Error500Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 演示500错误，即代码中包含运行时的异常
//        int i = 1/0;
        throw new RuntimeException("运行时异常了！");
        /*
        HTTP Status 500 – Internal Server Error
         */
    }
}
