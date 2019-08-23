package com.hsc.requestbody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name = "BodyServlet", urlPatterns = "/GetRequestDataServlet")
public class BodyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取请求体
        /**
         * request获取get或post提交请求数据的api方法
         * 1. request.getParameter(String name) 根据请求参数数据的name获取对应的一个Sting类型的value
         * 2. request.getParameterValues(String name) 根据请求参数数据的name获取一组String[]的数据
         * 3. request.getParameterMap() 获取所有请求参数数据的键值对返回一个Map<String,String[]>
         */

        /*
          解决POST提交中文乱码问题:
          一定要在request使用前设置，否则无效。
         */
        request.setCharacterEncoding("UTF-8");
        // 获取所有参数名字
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println("name = " + name);
        }

        // 1. 获取姓名
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        // 2. 获取性别
        String gender = request.getParameter("gender");
        System.out.println("gender = " + gender);

        // 3. 获取城市
        String city = request.getParameter("city");
        System.out.println("city = " + city);

        // 4. 获取爱好，有多个值
        String[] hobby = request.getParameterValues("hobby");
        System.out.println("hobby = " + Arrays.toString(hobby));
    }
}
