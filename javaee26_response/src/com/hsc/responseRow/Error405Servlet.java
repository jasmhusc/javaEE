package com.hsc.responseRow;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "Error405Servlet", urlPatterns = "/Error405Servlet")
public class Error405Servlet extends HttpServlet {

    // 演示404，没有doGet()和doPost()方法的错误
    /*
    HTTP Status 405 – Method Not Allowed
     */
}
