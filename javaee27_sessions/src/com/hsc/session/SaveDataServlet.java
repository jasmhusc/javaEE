package com.hsc.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SaveDataServlet", urlPatterns = "/SaveDataServlet")
public class SaveDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // session可以存储数据，数据在一个session期间，可以在不同的servlet键传递，共享。
        HttpSession session = request.getSession();
        session.setAttribute("name", "successfully");
        response.getOutputStream().println("I successfully saved data in session!");
    }
}
