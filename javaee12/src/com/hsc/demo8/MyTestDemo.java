package com.hsc.demo8;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author HuscLove
 * @version 1.1
 * @package com.hsc.
 * @date 2019/7/29 00:44
 */
public class MyTestDemo {
    @Test
    public void testMyTest() throws Exception {

        // 测试模拟Test注解的自定义注解：MyTest注解
        Class<?> aClass = Class.forName("com.hsc.demo8.Animal");
        Method[] methods = aClass.getDeclaredMethods();

        // 判断方法上是否含有注解
        for (Method m : methods) {
            boolean b = m.isAnnotationPresent(MyTest.class);
            /*
             存在注解则调用该方法
             */
            if (b) {
                m.invoke(aClass.newInstance());
            }
        }
    }
}
