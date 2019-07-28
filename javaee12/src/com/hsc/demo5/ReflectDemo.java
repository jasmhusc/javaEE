package com.hsc.demo5;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 1.定义学生/老师等类
 * 2.创建一个配置文件config.properties
 * 2.1配置类名
 * 2.2配置方法名
 * 3.加载properties的数据到Properties对象中
 * 4.根据类名获取Class对象
 * 5.根据方法名获取方法
 * 6.使用反射执行方法
 * <p>
 * 优点：反射降低耦合性,提高代码的灵活性和扩展性.
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {

        // 3.加载properties的数据到Properties对象中
        Properties pp = new Properties();
        pp.load(new FileInputStream("javaee12/config.properties"));

        // 4.根据类名获取Class对象
        String classname = pp.getProperty("classname");
        Class<?> aClass = Class.forName(classname);
        Object obj = aClass.newInstance();

        // 5.根据方法名获取方法
        String methodname = pp.getProperty("methodname");
//        System.out.println("methodname = " + methodname); 测试一下
        Method method = aClass.getDeclaredMethod(methodname);

        // 6.使用反射执行方法
        method.invoke(obj);
    }
}
