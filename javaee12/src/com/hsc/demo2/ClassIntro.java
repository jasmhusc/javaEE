package com.hsc.demo2;

import com.hsc.bean.Employee;

/**
 * 1. 对象包含类实例，即普通new操作的对象，以及Class对象
 * 2. 类名是Class,这个Class类创建的对象,我们称为Class对象
 * public final class Class<T> {
 * // 成员变量
 * // 成员方法
 * }
 * 3. 当class文件加载到内存时,JVM会创建一个Class对象,
 * Class对象会保存class文件里面的成员变量,成员方法,构造方法等类里面的信息
 * 4. Class对象时反射必须要用到的东西
 */
public class ClassIntro {
    public static void main(String[] args) throws ClassNotFoundException {

        /*
         获得Class对象的3中方式
          */

        // 1. 类名.class
        Class<Employee> eClass1 = Employee.class;

        // 2. 类实例.getClass()
        Employee e = new Employee();
        Class<? extends Employee> eClass2 = e.getClass();

        // 3. Class.forName(“包名.类名”) :类全名
        Class<?> eClass3 = Class.forName("com.hsc.bean.Employee");

        System.out.println(eClass1 == eClass2); // true
        System.out.println(eClass1 == eClass3); // true
    }
}
