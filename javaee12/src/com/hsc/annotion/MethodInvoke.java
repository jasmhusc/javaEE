package com.hsc.annotion;

import java.lang.reflect.Method;

public class MethodInvoke {

    public static void invoke(String string) throws Exception {

        // 获取运行时类
        Class cls = Color.class;

        // 获取本类所有方法
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {

            // 判断方法上是否有注解    MyAnnotation
            if (method.isAnnotationPresent(MyAnnotation.class)) {

                // 得到注解
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                // 获取注解的 value
                String value = annotation.value();
                if (string.equals(value)) {

                    // 执行该方法
                    method.invoke(cls.newInstance());
                }
            }
        }
    }
}
