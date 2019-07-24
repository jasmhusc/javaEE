package com.hsc.demo7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 读取一张图片，复制到项目下
 * FileInputStream, FileOutputStream
 * write(byte[] ,off, len)
 */
public class IODemo {
    public static void main(String[] args) throws IOException {

        // 创建流对象
        FileInputStream fis = new FileInputStream("F:/myjavafile/test.jpg");
        FileOutputStream fos = new FileOutputStream("javaee09/file/copy7.jpg");

        // 复制文件
        int len;
        byte[] arr = new byte[1024];
        while ((len = fis.read(arr)) != -1) {
            fos.write(arr, 0, len);
            // 刷新缓冲区
            fos.flush();
        }

        // 关流
        fis.close();
        fos.close();
    }
}
