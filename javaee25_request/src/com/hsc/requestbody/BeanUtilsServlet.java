package com.hsc.requestbody;

import entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "BeanUtilsServlet", urlPatterns = "/BeanUtilsServlet")
public class BeanUtilsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 使用BeanUtils一次性将浏览器提交的表单所有数据封装到JavaBean中
         * 核心方法：  BeanUtils.populate(封装的对象,Map<String,Object>)
         */
        // 1. 设置获取请求的编码：utf-8
        request.setCharacterEncoding("utf8");

        // 2. getParameterMap()得到map集合
        //1.创建一个User的java类设计属性可以封装表单的所有数据
        //2.实例User类
        Map<String, String[]> map = request.getParameterMap();

        // 3. 封装成User
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
            //如果发生系统异常，给出用户友好信息，也需要进行编码设置解决乱码。
            response.setContentType("text/html;charset=utf8");
            response.getWriter().write("服务器繁忙...");
        }

        // 4.输出一下，查看结果
        System.out.println("user = " + user);
    }
}
