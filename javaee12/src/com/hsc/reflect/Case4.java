package com.hsc.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@SuppressWarnings("all")
/*
 * 获取成员函数
 */
public class Case4 {

    public static void main(String[] args) throws Exception {

        // 获取运行时类
        Class<Goods> cls = Goods.class;

        Goods goods = new Goods("台灯", 22.8, 30);

        System.out.println("-------------------getDeclaredMethods()演示-----------------");
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            // 获取访问修饰符
            int modifiers = method.getModifiers();
            String string = Modifier.toString(modifiers);
            // 获取返回值名称
            Class<?> returnType = method.getReturnType();
            String simpleName = returnType.getSimpleName();
            // 获取方法名称
            String name = method.getName();

            System.out.println(string + " " + simpleName + " " + name);

            // 获取参数列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls1 : parameterTypes) {
                System.out.println(cls1.getSimpleName());
            }
            // 调用方法
            method.setAccessible(true);
            if ("setName".equals(name)) {
                method.invoke(goods, "风扇");
            }
        }
        System.out.println(goods);
        System.out.println("-------------------getDeclaredMethod(String name)演示-----------------");
        Method method = cls.getDeclaredMethod("toString");
        System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName() + " " + method.getName());
        // 没有参数给  null 只是调用toString方法
        // 第一个参数：方法所在的对象           第二个参数：传给方法的值
        // 返回值是该goods对象
        Object value = method.invoke(goods, null);
        System.out.println(value);
        System.out.println("-------------------getMethods()演示-----------------");
        Method[] Methods2 = cls.getMethods();
        for (Method method2 : Methods2) {
            System.out.println(Modifier.toString(method2.getModifiers()) + " " + method2.getReturnType().getSimpleName() + " " + method2.getName());
        }
        System.out.println("-------------------getMethod()演示-----------------");
    }

}