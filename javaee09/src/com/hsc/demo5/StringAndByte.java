package com.hsc.demo5;

import java.util.Arrays;

/**
 * String 和 Byte的转换
 */
public class StringAndByte {
    public static void main(String[] args) {
        // byte[] 转成 String
        byte[] buf = new byte[]{97, 98, 99, 100};
        String str = new String(buf);
        System.out.println("str = " + str); // str = abcd

        // String 转成 byte[]
        byte[] bytes = "hello".getBytes();
        System.out.println(Arrays.toString(bytes));
    }
}
