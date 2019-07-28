package com.hsc.demo4;

import com.hsc.bean.Employee;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 1. Method getMethod(String name,Class...args);
 * 根据方法名和参数类型获得对应的构造方法对象，只能获得public的
 * 2. Method getDeclaredMethod(String name,Class...args);
 * 根据方法名和参数类型获得对应的构造方法对象，包括private的
 * 3. Method[] getMethods();
 * 获得类中的所有成员方法对象，返回数组，只能获得public修饰的且包含父类的
 * 4. Method[] getDeclaredMethods();
 * 获得类中的所有成员方法对象，返回数组,只获得本类的，包含private修饰的
 * <p>
 * 1. Object invoke(Object obj, Object... args)
 * 调用指定对象obj的该方法
 * args：调用方法时传递的参数
 * 2. void setAccessible(true)
 * 设置是否取消权限检查，true取消权限检查，false表示不取消(暴力反射)
 */
public class ReflectMethod {
    private Employee e;

    @Before
    public void init() {
        // 初始化e
        e = new Employee("老王", 29);
    }

    @Test
    public void testGetDelcMethod() throws Exception {
        // 获取一个方法
        Class<Employee> aClass = Employee.class;
        Method m = aClass.getMethod("setName", String.class);
        // 调用方法
        m.invoke(e, "卡卡");
//        m.invoke(null,"伦纳德");  object不能为空
        System.out.println(e);
    }

    @Test
    public void testGetMethods() {
        // 获取所有public方法
        Class<Employee> aClass = Employee.class;
        Method[] methods = aClass.getMethods();
        // 遍历输出所有public方法
        for (Method m : methods) {
            System.out.println(m);
        }
    }

    @Test
    public void testGetMethod() throws Exception {
        // 获取一个方法
        Class<Employee> aClass = Employee.class;
        Method m = aClass.getDeclaredMethod("sleep", int.class);

        // 调用方法，暴力反射
        m.setAccessible(true);
        Object o = m.invoke(e, 2);
        System.out.println(o);
    }

    @Test
    public void testGetDelcMethods() {
        // 获取所有方法
        Class<Employee> aClass = Employee.class;
        Method[] methods = aClass.getDeclaredMethods();

        // 遍历输出所有方法
        for (Method m : methods) {
            System.out.println(m);
        }
    }
}
