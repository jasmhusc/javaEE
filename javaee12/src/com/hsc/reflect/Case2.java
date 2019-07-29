package com.hsc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

@SuppressWarnings("all")
public class Case2 {
    /*
     * 获取构造
     * 1 public
     * 2 private
     */
    public static void main(String[] args) throws Exception {

        Class cls = Goods.class;
        System.out.println("---------------------------class.getInterfaces--------------------------------");
        // 获取类实现的接口
        Class[] interfaces = cls.getInterfaces();

        for (Class class1 : interfaces) {

            System.out.println(class1.getName());
            System.out.println(class1.getSimpleName());  // 简称
        }

        System.out.println(Goods.class.getSuperclass().getName());  // 获取父类名
        System.out.println("-----------------------------class.getConstructors------------------------------");

        Constructor<Goods>[] cons = cls.getConstructors();
        for (Constructor constructor : cons) {
            // 获取修饰符
            System.out.println(constructor.getModifiers() + " " + constructor.getName());

            Class<Goods>[] parameters = constructor.getParameterTypes();
            for (Class clss : parameters) {
                System.out.println(clss.getSimpleName());
            }
        }
        System.out.println("----------------------------class.getConstructor-------------------------------");

        // 获取指定构造
        Constructor<Goods> construtor = cls.getConstructor(String.class, Double.class, Integer.class);
        // 创建对象
        Goods goods = construtor.newInstance("张思", 23.24, 50);
        System.out.println(goods);
        // 将int类型的修饰符转换为String输出
        System.out.println(Modifier.toString(construtor.getModifiers()));

        System.out.println("------------------------------class.getDeclaredConstructor-----------------------------");
        Constructor<Goods> construtor2 = cls.getDeclaredConstructor(String.class, Integer.class);
        // 创建对象
        // 打破封装
        construtor2.setAccessible(true);
        Goods goods2 = construtor2.newInstance("Paul", 43);
        System.out.println(goods2);
        // 将int类型的修饰符转换为String输出
        System.out.println(Modifier.toString(construtor2.getModifiers()));
    }
}