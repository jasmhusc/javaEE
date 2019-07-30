package com.hsc.proxy;

public class TestProxy {

    /*
        通常的使用步骤：
     */
    public static void main(String[] args) {

        // 1.创建接口的实现类：真实对象
        UserDaoImp udi = new UserDaoImp();
        // 2.创建真实对象的：代理类对象（封装类）
        UserProxy up = new UserProxy(udi);

        // 3.调用代理类的方法，获得一个具体的代理类对象
        UserDao proxyObject = (UserDao) up.getProxyObject();   // 返回的是  接口UserDao的一个实例
        // 4.使用代理类完成业务功能
        proxyObject.delete();  // 代理实例与UserDaoImp实例是平行关系

        System.out.println(proxyObject.apply(4));
    }

}
