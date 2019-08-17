package com.hsc.responseRow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SendCodeServlet", urlPatterns = "/SendCodeServlet")
public class SendCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*操作response设置状态码相关api方法*/

        //1.设置状态码方法，单独使用没有任何效果和含义，必须配合响应头设置才有效果
        response.setStatus(302);

        //2.发送一个错误码
//        response.sendError(404);

        //3.发送错误和信息
        response.sendError(404, "您的url写错了！");
    }
}
