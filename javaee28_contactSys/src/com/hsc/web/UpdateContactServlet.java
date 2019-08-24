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

@WebServlet(name = "UpdateContactServlet", urlPatterns = "/UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {
    private ContactService service = new ContactService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 更新联系人信息
            Map<String, String[]> map = request.getParameterMap();
            Contact contact = new Contact();
            BeanUtils.populate(contact, map);
            service.updateContact(contact);
            // 更新成功，跳转联系人页面。
            response.sendRedirect(request.getContextPath() + "/list");
        } catch (Exception e) {
            e.printStackTrace();
            // 更新失败，弹出失败框，回到更新联系人页面。
            response.getWriter().write("<script>alert('很遗憾，更新失败！');history.back();</script>");
        }
    }
}
