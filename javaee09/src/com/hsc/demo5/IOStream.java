package com.hsc.demo5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流的顶级父类(抽象类):
 * 字节流                                 字符流
 * 输入流         字节输入流InputStream                字符输入流Reader
 * 输出流         字节输出流OutputStream               字符输出流Writer
 */
public class IOStream {
    public static void main(String[] args) throws IOException {
/*
    单个字符写入：write(int  b)
    写入的是字节byte，用int接收
 */
        // FileOutputStream 和 FileInputStream
        FileOutputStream fos = new FileOutputStream("javaee09/file/a5_2.txt");
        FileInputStream fis = new FileInputStream("javaee09/file/a5_2.txt");

        // 写入一个字节并读取
        fos.write(99);
        fos.write('我');
        fos.flush();
        int i = fis.read();
        int j = fis.read();

        // 控制台打印输出
//        System.out.println(i); // 99
        System.out.println((char) i); // 转成字符类型 c
        System.out.println((char) j); // 乱码

        // 关流
        fos.close();
        fis.close();
    }
}
