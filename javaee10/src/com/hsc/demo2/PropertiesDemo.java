package com.hsc.demo2;

import java.util.Properties;
import java.util.Set;

/**
 * Map
 * ↑实现
 * Hashtable
 * ↑继承
 * Properties
 * Properties类：
 * Properties类表示一组持久的属性。
 * Properties可以保存到流中或从流中加载。
 * Properties中的每个键及其对应的值都是一个字符串。
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        // 创建properties对象
        Properties pp = new Properties();

        // 添加数据
        pp.setProperty("姓名", "菜虚坤");
        pp.setProperty("年龄", "23");
        pp.setProperty("才艺", "篮球");
        System.out.println(pp);

        // 键找值
        String name = pp.getProperty("姓名");
        String age = pp.getProperty("年龄");
        String skill = pp.getProperty("才艺");
        System.out.println(name + "::" + age + "::" + skill);

        // 遍历
        Set<String> keys = pp.stringPropertyNames();
        for (String key : keys) {
            String value = pp.getProperty(key);
            System.out.println(key + "::" + value);
        }

        // Stream遍历
        keys.stream().forEach(k -> System.out.println(k + "::" + pp.getProperty(k)));
    }
}
