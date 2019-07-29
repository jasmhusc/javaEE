package com.hsc.demo10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;

public class LogProxy {

    // 获取学校服务类的代理类
    public static Object getProxy(Object obj) {

        // 创建实例对象
        SchoolServiceImpl schoolService = new SchoolServiceImpl();
        /*
         创建代理对象:

          */
        Object object = Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{SchoolService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {

                // 增强，记录方法执行时间，并返回日志记录。
                long start = System.currentTimeMillis();

                try {
                    // 调用方法，实现委托类的方法，返回代理对象。
                    return method.invoke(obj, args);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    long end = System.currentTimeMillis();
                    // 在什么时刻执行完，花费了多长时间完成。
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println(method.getName() + "方法执行->"
                            + sdf.format(end) + "，耗时："
                            + (end - start));
                }
            }
        });

        return object;
    }
}
