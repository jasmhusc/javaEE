package com.hsc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy {

    private Object obj;

    public UserProxy(Object obj) {
        super();
        this.obj = obj;
    }

    public Object getProxyObject() {

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("Before");
                Object invoke = method.invoke(obj, args); // 执行方法，结果用invoke接收一下
                System.out.println("After");

                return invoke;   // 返回结果，没有结果就是返回null
            }
        });

    }
}
