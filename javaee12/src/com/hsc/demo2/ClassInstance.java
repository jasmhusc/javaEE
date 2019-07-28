package com.hsc.demo2;

import com.hsc.bean.Employee;

import java.lang.reflect.Constructor;

/**
 * 类实例的集中创建方式。
 */
public class ClassInstance {
    public static void main(String[] args) throws Exception {

        // 1. new 构造方法
        Employee e1 = new Employee();

        // 2. 由.class对象的：getInstance()
        Class<Employee> aClass = Employee.class;
        Employee e2 = aClass.newInstance();

        // 3. 反射得到Constructor
        Constructor<Employee> con = aClass.getConstructor(String.class, int.class);
        Employee e3 = con.newInstance("孙杨", 28);
    }
}
