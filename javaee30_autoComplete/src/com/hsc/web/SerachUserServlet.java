package com.hsc.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsc.entity.User;
import com.hsc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SerachUserServlet", urlPatterns = "/SerachUserServlet")
public class SerachUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private UserService userService = new UserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取word，查询获取结果，返回
        String word = request.getParameter("word");
        List<User> users = userService.findUsersByName(word);
        String userJson = new ObjectMapper().writeValueAsString(users);
        // 返回
        System.out.println("userJson = " + userJson);
        response.getWriter().write(userJson);
    }
}
