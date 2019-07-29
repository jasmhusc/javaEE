package com.hsc.demo8;

/*
    Bean: 用于测试MyTest注解的有效性。
    包含@MyTest的方法必须为：public void xxx(){}
 */
public class Animal {

    public void getUp() {
        System.out.println("起床啦");
    }

    @MyTest
    public void eat() {
        System.out.println("吃饭啦");
    }

    public void study() {
        System.out.println("学习啦");
    }

    @MyTest
    public void sleep() {
        System.out.println("睡觉啦");
    }
}
