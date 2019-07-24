package com.hsc.demo6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 读取字符，没有指定按数组读到的长度读取，可能会有残留。
 * 追加数据
 * FileOutputStream​(File file, boolean append)
 * FileOutputStream​(String name, boolean append)
 * 当append设置为true时,就不会删掉以前的,在之前的基础上追加写入数据
 */
public class TestDemo {
    public static void main(String[] args) throws IOException {
        // 写入英文字母，不会报错
        write();
        read();
    }

    private static void read() throws IOException {
        FileInputStream fis = new FileInputStream("javaee09/file/a6_2.txt");
        int len;
        byte[] arr = new byte[4];
        while (fis.read(arr) != -1) {
            System.out.println(new String(arr));
        }
    }

    private static void write() throws IOException {
        // 一个字节数组写入
        FileOutputStream fos = new FileOutputStream("javaee09/file/a6_2.txt", true);
        byte[] byteArr = "ILoveChina".getBytes();
        fos.write(byteArr);

        // 关流
        fos.close();
    }
}
