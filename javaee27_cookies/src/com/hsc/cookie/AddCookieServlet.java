package com.hsc.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCookieServlet", urlPatterns = "/AddCookieServlet")
public class AddCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        http链接的无状态：
         服务器根据浏览器传递过来的数据，创建cookie，添加cookie，浏览器会保存；
         下次交互直接携带cookie，不在直接输入数据。
         */
        Cookie cookie = new Cookie("name", "james");
        response.addCookie(cookie);
        // 可以添加多个Cookie
        Cookie cookie1 = new Cookie("age", "23");
        //修改有效期，半小时过期，如果不设置采用默认浏览器关闭过期
        cookie1.setMaxAge(60 * 30);// 单位为秒
        response.addCookie(cookie1);
        /*
        响应头包含2个Set-Cookie，浏览器会保存2个cookie，下次请求时会默认自动携带。
        cookie保存到是String类型的键值对，大小限制4kb，浏览器对于cookie的个数一般限制为50个。
         */
    }
}
