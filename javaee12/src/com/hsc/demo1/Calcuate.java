package com.hsc.demo1;

/**
 * 定义一个关于整数计算的类，加减乘除。
 * 编写测试类进行方法测试。
 */
public class Calcuate {

    /**
     * 业务类：实现加减乘除运算
     */
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int calc(int a, int b) {
        return a - b;
    }

    public static int plus(int a, int b) {
        return a * b;
    }

    public static double div(int a, int b) {
        return ((double) a / b);
    }
}
