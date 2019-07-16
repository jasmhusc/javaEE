package demo5;

import java.math.BigDecimal;

public class BigDecimalDemo {
    /*
     * 精确计算
     * 构造函数： new BigDecimal(String s)
     * add  +
     * subsract -
     * multiply *
     * divide
     * */

    public static void main(String[] args) {

        System.out.println(2.0 - 1.1);     // 不精确

        BigDecimal bd1 = BigDecimal.valueOf(2.0);
        BigDecimal bd2 = BigDecimal.valueOf(1.1);
        System.out.println(bd1.subtract(bd2));     // 更加精确

        BigDecimal a = new BigDecimal("6.54");
        BigDecimal b = new BigDecimal("2.00");

        /** 基本计算练习
         *  除不尽就会抛出异常
         */
        // 加 +
        BigDecimal add = a.add(b);
        System.out.println("add = " + add);
        // 减 -
        BigDecimal subtract = a.subtract(b);
        System.out.println("subtract = " + subtract);
        // 乘 *
        BigDecimal multiply = a.multiply(b);
        System.out.println("multiply = " + multiply);
        // 除 /
        BigDecimal divide = a.divide(b);
        System.out.println("divide = " + divide);
    }

}
