package com.hsc.web;

import com.hsc.service.Contact2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContactListServlet", urlPatterns = "/ContactListServlet")
public class ContactListServlet extends HttpServlet {
    private Contact2Service service = new Contact2Service();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 无序获取参数，直接调用业务，获取数据并返回
        String contacts = service.findAllContacts();
        response.getWriter().write(contacts);
    }
}
