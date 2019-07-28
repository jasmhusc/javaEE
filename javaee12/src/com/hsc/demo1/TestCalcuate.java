package com.hsc.demo1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Junit是java的一个第三方单元测试框架
 * 第一方:JDK提供的类
 * 第二方:自己写的类
 * 第三方:其他人写的很多类
 * <p>
 * 测试类：public void testFunc(){}
 */
public class TestCalcuate {
    @Test
    public void testSum() {
        // 测试：3+5
        int sum = Calcuate.sum(3, 5);
        /*
            断言：预习判断某个条件一定成立，如果条件不成立，则直接奔溃。
            assertEquals方法的参数
            (String message, double expected, double actual)
            message： 消息字符串
            expected: 期望值
            actual: 实际值
        */
        // 如果期望值和实际值一致，则什么也不发生，否则会直接奔溃。
        Assert.assertEquals(8, sum);
        System.out.println(sum);
    }

    @Test
    public void testCalc() {
        // 测试：3-5
        int calc = Calcuate.calc(3, 5);
        /*
        断言: 看我们猜测的值,和真是的是是否一样
        Assert.assertEquals(猜测值, 真实值);
        */
        Assert.assertEquals(-2, calc);
        System.out.println(calc);
    }

    @Test
    public void testPlus() {
        // 测试：3*5
        int plus = Calcuate.plus(3, 5);
        /*
        断言: 看我们猜测的值,和真是的是是否一样
        Assert.assertEquals(猜测值, 真实值);
        */
        Assert.assertEquals(15, plus);
        System.out.println(plus);
    }

    @Test
    public void testDiv() {
        // 测试：3/5
        double div = Calcuate.div(3, 5);

        System.out.println(div);
    }
}
