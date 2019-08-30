package com.hsc.web;

import com.hsc.service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AreaServlet", urlPatterns = "/AreaServlet")
public class AreaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private AreaService service = new AreaService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 查询cities，返回
        response.setContentType("text/json;charset=utf-8");
        int pid = Integer.parseInt(request.getParameter("pid"));
        String json = service.findCities(pid);
        response.getWriter().write(json);
    }
}
