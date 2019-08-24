package com.hsc.web;

import com.hsc.entity.Contact;
import com.hsc.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListContactServlet", urlPatterns = "/list")
public class ListContactServlet extends HttpServlet {
    private ContactService service = new ContactService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
          需要用到service层，将service对象作为全局变量，与servlet一起生成。
         调用service层查询数据，将结果存储进域中，转发给jsp去显示。
         */
        List<Contact> contacts = service.findAllContacts();
        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
