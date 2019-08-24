package com.hsc.web;

import com.hsc.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteContactServlet", urlPatterns = "/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
    private ContactService service = new ContactService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 删除联系人
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteContact(id);
        // 删除成功，跳转联系人界面：list.jsp
        response.sendRedirect(request.getContextPath() + "/list");
    }
}
