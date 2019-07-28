package com.hsc.demo2;

import com.hsc.bean.Employee;

/**
 * Class类常用方法：
 * String getSimpleName(); 获得类名字符串：类名
 * String getName(); 获得类全名：包名+类名
 * T newInstance() ; 创建Class对象关联类的对象
 */
public class ClassFunc {
    public static void main(String[] args) throws Exception {

        // 获得.class对象
        Class<Employee> aClass = Employee.class;

        // 获得类名字符串：类名
        String name = aClass.getSimpleName();
        System.out.println(name);

        // 获得类全名：包名+类名
        String simplename = aClass.getName();
        System.out.println(simplename);

        // 创建Class对象关联类的对象
        Employee e = aClass.newInstance();
        e.setName("樱木花道");
        System.out.println(e);
    }
}
