package com.hsc.lifecircle;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
/*
 * 面试题：
 *   1.请说出servlet生命周期相关方法
 *       init方法
 *       service方法
 *       destroy方法
 *   2.servlet对象什么时候创建的？
 *       默认第一次调用时候创建，服务器创建的
 *   3.servlet对象创建了几次？
 *       只创建一次，全局唯一，单例模式对象，节省内存
 *   4.servlet默认是在第一次访问时创建，能修改为启动时创建？
 *       可以的,设置loadOnStartup的值为1~6的一个值代表服务器启动时创建
 *       值越小代表越先创建
 *       ctrl+alt+u  查看继承体系
 * */
@WebServlet(urlPatterns = "/LifeCircle")
public class LifeCircle implements Servlet {

    // 构造方法在第一次请求时调用，单例模式，实例化。

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        /*
         初始化，在第一次请求时初始化的时候执行；
         可以提前加载：load-on-startup，取值1~6
         <load-on-startup>1</load-on-startup>
         小的值在前面加载，大的值在后面加载。如果是负数与不写是一样的。。
          */
        System.out.println("init()被调用了");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //请求处理方法，每次请求都会调用
        System.out.println("service()被调用了");
    }

    @Override
    public void destroy() {
        // 在服务器关闭或重启时，servlet销毁，执行一次。
        System.out.println("destroy()被调用了");
    }

    // 得到一个配置对象，不属于生命周期的方法
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
