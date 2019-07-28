package com.hsc.demo4;

import com.hsc.bean.Employee;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 反射获取构造方法的方式，参数为原构造函数中：参数类型.class
 * 1. getConstructor()
 * 2. getDeclaredConstructor()
 * 3. getConstructors()
 * 4. getDeclaredConstructors()
 * <p>
 * 1. T newInstance(Object... initargs)
 * 根据指定的参数创建对象
 * 2. void setAccessible(true)
 * 设置是否取消权限检查，true取消权限检查，false表示不取消(暴力反射)
 */
public class RefkectConstructor {
    @Test
    public void testGetCon() throws Exception {
        // 获取某一个构造函数
        Class<Employee> aClass = Employee.class;
        Constructor<Employee> con = aClass.getConstructor(String.class, int.class);
        Employee employee = con.newInstance("孙杨", 26);
        System.out.println(employee);
    }

    @Test
    public void testGetCons() throws Exception {
        // 获取某一个构造函数
        Class<Employee> aClass = Employee.class;
        Constructor<?>[] cons = aClass.getConstructors();
        // 遍历所有public构造函数
        for (Constructor<?> con : cons) {
            System.out.println(con);
        }
    }

    @Test
    public void testGetDeclCon() throws Exception {
        // 获取某一个构造函数
        Class<Employee> aClass = Employee.class;
        Constructor<Employee> con = aClass.getDeclaredConstructor(String.class);

        // 创建类实例时会报错，需要打破封装，取消权限检查
        con.setAccessible(true);
        Employee employee = con.newInstance("孙杨");
        System.out.println(employee);
    }

    @Test
    public void testGetDeclCons() throws Exception {
        // 获取某一个构造函数
        Class<Employee> aClass = Employee.class;
        Constructor<?>[] cons = aClass.getDeclaredConstructors();
        // 遍历所有构造函数
        for (Constructor<?> con : cons) {
            System.out.println(con);
        }
    }
}
