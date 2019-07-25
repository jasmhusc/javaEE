package com.hsc.demo8;

import java.io.*;

/**
 * 1.ObjectInputStream反序列化流，将之前使用ObjectOutputStream序列化的原始数据恢复为对象。
 * 2.public ObjectInputStream(InputStream in) ：
 * 创建一个指定InputStream的ObjectInputStream。
 * 3.public final Object readObject () :
 * 读取一个对象。
 */
public class DeserializaDemo {
    public static void main(String[] args) {

        // 指定序列化存储路径
        File file = new File("javaee10/file/serial.txt");

        // 反序列化
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ) {
            // 反序列化，读取对象
            Employee employee = (Employee) ois.readObject();
            System.out.println(employee);
            // Employee{name='林俊杰', age=0, address='null'}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
