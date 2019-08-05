package com.hsc.mybatis;

import java.lang.reflect.Proxy;

public class SqlSession {
    // 无参构造
    public SqlSession() {
    }

    // 创建DAO中的UserMapper代理类实例对象
    public <T> T getMapper(Class<T> cls) {
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new MyInvocationHandler());
        return t;
    }
}
