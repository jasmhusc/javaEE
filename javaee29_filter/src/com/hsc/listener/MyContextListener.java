package com.hsc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * servletContext对象是服务器启动时最早最先创建的对象，比过滤器早；服务器关闭的时候销毁。
 */
@WebListener()  //注解含义：将当前监听器类交给服务器管理，把当前监听器注册进服务器。
public class MyContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        /* servlet context被初始化时（web应用部署时）调用，可以在此处进行资源的初始化。*/
        /*
         * 获取到servletContext创建的时间点有什么用？ServletContextListener的作用？
         * 答：我们因为上下文域对象的创建是最早的时间点，通常可以做如下2个操作：
         *       1.加载自定义配置文件数据,spring框架的配置文件就是使用这个监听器进行加载的
         *       2.开启定时器任务运行
         *              定时器任务：按照指定的时间执行任务
         *              js的定时器语法：setInterval()或setTimeout()
         * */
        // 创建定时器
        Timer timer = new Timer();
        // 执行定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                System.out.println(date);
            }
        }, 0, 1000);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        /* web应用被移除或关闭服务器时调用*/
    }
}
