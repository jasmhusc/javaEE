package com.hsc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfigDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
         *  ServletConfig 可以获取servlet配置的一些信息，参数信息
         */
        // 1.得到servlet配置对象，专门用于在配置servlet的信息
        ServletConfig servletConfig = getServletConfig();

        // 获取的是配置servlet里面的servlet-name的文本内容，不是本类的类名
        String servletName = servletConfig.getServletName();
        System.out.println("servletName = " + servletName);

        /*
         *  2.可以获取具体的某一个参数
         *  参数在配置servlet时添加初始化参数标签，给定相应的名称和值
         */
        String name = servletConfig.getInitParameter("name");
        System.out.println("name = " + name);

        /*
         * 3.可以获取所有参数，返回一个枚举
         * 2的加强版，一次性获取所有参数的名称，遍历。
         */
        System.out.println("-----------------------");
        Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
        while (parameterNames.hasMoreElements()){
            String element = parameterNames.nextElement();
            String value = servletConfig.getInitParameter(element);
            System.out.println("name==="+element+"  value==="+value);
        }

        /*
         * 4.为什么需要servletconfig，获取参数有什么用？
         * 目的：其他人或公司在导入servlet的jar时，必须写某些参数，不同公司写不一样的值
         * 做法：在此处获取该参数的值，如果为null，抛出异常，提示别人配置servlet时添加该参数
         */
//        String numberValue = servletConfig.getInitParameter("number");
//        // 判断number参数的值
//        if(numberValue == null)
//            throw new IllegalArgumentException("配置servlet时必须添加number参数！");
//        else {
//            System.out.println("number==="+numberValue);
//        }
//        // 将此servlet的src导出为jar包，让另一个servlet工程引入，直接发布并访问，查看报错信息，并修改
//
    }
}
