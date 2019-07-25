package com.hsc.demo3;

import java.io.*;

/**
 * 缓冲流:
 * 字节流                  字符流
 * 输入流缓冲流      BufferedInputStream         BufferedReader
 * 输出缓冲流        BufferedOutputStream        BufferedWriter
 */
public class BufferedStream {
    public static void main(String[] args) throws IOException {

        // 创建缓冲流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("javaee10/file/bos.txt"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("javaee10/file/bos.txt"));

        // 写出数据到文本
        bos.write("Yestoday once more".getBytes());
        bos.flush();

        // 读取数据
        byte[] arr = new byte[1024];
        int len;
        while ((len = bis.read(arr)) != -1) {
            // 输出字节数组数据
            System.out.println(new String(arr, 0, len));
        }

        // 关流
        bos.close();
        bis.close();
    }
}
