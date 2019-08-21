package com.hsc.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DropSessionServlet", urlPatterns = "/DropSessionServlet")
public class DropSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // session的销毁控制
        // 1.设置session的销毁时间
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10); //单位为秒

        // invalidate，销毁session
        session.invalidate();
    }
}
