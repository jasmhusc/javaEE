package com.hsc.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JacksonServlet", urlPatterns = "/jackson")
public class JacksonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 测试jackson工具，对创建的对象转换为json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String data = objectMapper.writeValueAsString(new User("张三", "123"));
        response.getWriter().write(data);
    }
}
