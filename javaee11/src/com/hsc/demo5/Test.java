package com.hsc.demo5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {

        // 加载properties数据
        Properties pp = new Properties();
        try {
            pp.load(new FileInputStream("javaee11/upload/info.properties"));
        } catch (IOException e) {
        }

        // 遍历
        System.out.println(pp);
        // 取出value
        String value = pp.getProperty("name");
        System.out.println(value);
    }
}
