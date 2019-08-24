package com.hsc.web;

import com.hsc.entity.Contact;
import com.hsc.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindContactServlet", urlPatterns = "/FindContactServlet")
public class FindContactServlet extends HttpServlet {
    private ContactService service = new ContactService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 根据id查找联系人信息
        int id = Integer.parseInt(request.getParameter("id"));
        Contact contact = service.findContact(id);
        // 存进request域，请求转发给更新联系人页面，要更新的联系人原本的信息。
        request.setAttribute("contact", contact);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
