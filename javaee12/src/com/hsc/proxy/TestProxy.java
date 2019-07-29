package com.hsc.proxy;

public class TestProxy {

    public static void main(String[] args) {

        UserDaoImp udi = new UserDaoImp();
        UserProxy up = new UserProxy(udi);

        UserDao proxyObject = (UserDao) up.getProxyObject();   // 返回的式  接口UserDao的一个实例
        proxyObject.delete();  // 代理实例与UserDaoImp实例是平行关系

        System.out.println(proxyObject.apply(4));
    }

}
