package com.hsc.demo10;

import org.junit.Test;

public class TestLogProxy {
    @Test
    public void testLogProxy() {

        // 获取代理对象
        SchoolService schoolservice = (SchoolService) LogProxy.getProxy(new SchoolServiceImpl());

        // 执行业务1，测试登录代理功能
        String result1 = schoolservice.login("admin", "123456");
        System.out.println("result = " + result1);

        // 执行业务2，测试获取班级代理功能
        String result2 = schoolservice.getAllClazzs();
        System.out.println("result2 = " + result2);
    }
}
