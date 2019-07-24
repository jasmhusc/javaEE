package com.hsc.demo6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * InputStream: 输入字节流的父类
 * int read​(byte[] b) 读取多个数据,多个数据放到参数的byte数组中,返回读取到的个数
 */
public class IoStreamArray {
    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    private static void read() throws IOException {
        // 一个字节数组读取
        FileInputStream fis = new FileInputStream("javaee09/file/a6.txt");
        byte[] arr = new byte[3]; // 汉字占3个字节
        while (fis.read(arr) != -1) {
//            System.out.print(Arrays.toString(arr)); // 得到字节字符串，依然是字节
            // 输出读到字节数组中的字节，转为字符串
            System.out.print(new String(arr));
        }
        // 关流
        fis.close();
    }

    private static void write() throws IOException {
        // 一个字节数组写入
        FileOutputStream fos = new FileOutputStream("javaee09/file/a6.txt");
        byte[] bytearr = "我爱中国，我爱世界！".getBytes();
        fos.write(bytearr);

        // 关流
        fos.close();
    }
}

