package com.hsc.demo4;

import com.hsc.bean.Employee;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 反射之操作成员变量的目的
 * 通过Field对象给对应的成员变量赋值和取值
 * Field类概述
 * 每一个成员变量都是一个Field类的对象
 * set和get方法：
 * void set(Object obj, Object value)  引用类型
 * void setInt(Object obj, int i)
 * ...
 * Object get(Object obj)   引用类型
 * int getInt(Object obj)
 * ...
 * void setAccessible(true);暴力反射，设置为可以直接访问私有类型的属性。
 * Class getType(); 获取属性的类型，返回Class对象。
 */
public class ReflectField {
    @Test
    public void testField() throws Exception {
        // 获取一个属性，暴力反射
        Class<Employee> stuclass = Employee.class;
        Employee obj = stuclass.newInstance();
        Field f = stuclass.getDeclaredField("name");

        // 赋值 引用类型 f 已经代表了 name
        f.setAccessible(true);
        // 设置obj里的f（name）值
        f.set(obj, "杜兰特");
        // 获取obj里的f（name）值
        Object name = f.get(obj);
        System.out.println(name);
    }

    @Test
    public void testFields() throws Exception {
        // 获取一个属性，暴力反射
        Class<Employee> stuclass = Employee.class;
        Employee obj = stuclass.newInstance();
        Field[] fields = stuclass.getDeclaredFields();

        // 遍历输出所有属性
        for (Field f : fields) {
            System.out.println(f);
        }
    }
}
