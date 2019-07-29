package com.hsc.demo9;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ArrayListProxy {

    /*
     提供一个方法，用于生产委托对象的代理对象
     List为抽象对象，用于约束真实对象和代理对象，让它们具有相同的功能。
      */
    // 抽象对象：List
    public static List getProxy(ArrayList list) {
        /*
         proxy的静态方法：newProxyInstance()生成代理对象；
         需要传入参数：委托类的类加载器，委托类事项的接口的class（数组），函数调用处理器
          */
        ClassLoader classLoader = list.getClass().getClassLoader();
        Class[] interfaces = {List.class};
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 此处返回的代理函数调用委托函数的执行结果
                Object invoke = method.invoke(list, args);
                return invoke;
            }
        };
        List proxylist = (List) Proxy.newProxyInstance(classLoader, interfaces, handler);
        return proxylist;
    }

    @Test
    public void testListProxy() {
        // 创建真实对象
        ArrayList<Object> list = new ArrayList<>();
        // 获得代理对象
        List listproxy = ArrayListProxy.getProxy(list);

        // 调用者
        listproxy.add("paul");
        System.out.println(listproxy);
        listproxy.remove("paul");
    }
}
