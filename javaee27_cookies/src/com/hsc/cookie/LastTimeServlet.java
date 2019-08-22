package com.hsc.cookie;


import com.hsc.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name = "LastTimeServlet", urlPatterns = "/LastTimeServlet")
public class LastTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 显示上次访问时间，如果是第一次就直接显示欢迎访问。
        // 1.获取最后一次访问的时间对应的cookie：lasttime--long
        // 解决乱码
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Cookie c = CookieUtil.findCookie(cookies, "lasttime");
        if (c != null) {
            long l = Long.parseLong(c.getValue());
            String time = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(l);
            response.getWriter().write("欢迎，您上次访问的时间为：" + time);
        } else {
            response.getWriter().write("欢迎您的来访！");
        }

        // 2.添加cookie
        Cookie lasttime = new Cookie("lasttime", System.currentTimeMillis() + "");
        response.addCookie(lasttime);
    }
}
