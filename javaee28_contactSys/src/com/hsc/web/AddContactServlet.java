package com.hsc.web;

import com.hsc.entity.Contact;
import com.hsc.service.ContactService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddContactServlet", urlPatterns = "/AddContactServlet")
public class AddContactServlet extends HttpServlet {
    private ContactService service = new ContactService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 添加联系人
            Map<String, String[]> map = request.getParameterMap();
            Contact contact = new Contact();
            BeanUtils.populate(contact, map);
            service.addContact(contact);
            // 添加成功，跳转联系人显示页面
            response.sendRedirect(request.getContextPath() + "/list");
        } catch (Exception e) {
            e.printStackTrace();
            // 添加失败，提示信息，回到添加页面
            response.getWriter().write("<script>alert('很遗憾，添加失败!');history.back();</script>");
        }
    }
}
