package com.hsc.demo7;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 目标:将GBK编码的文本文件，转换为UTF-8编码的文本文件
 * 步骤:
 * 1.创建一个InputStreamReader,指定字符集为GBK
 * 2.创建一个OutputSreamWriter,指定字符集为UTF-8
 * 3.循环读写
 * 4.关闭流
 */
public class Trans {
    public static void main(String[] args) throws IOException {

        // 1.创建一个InputStreamReader,指定字符集为GBK
        InputStreamReader isr = new InputStreamReader(new FileInputStream("javaee10/file/out_gbk.txt"), "gbk");

        // 2.创建一个OutputSreamWriter,指定字符集为UTF-8
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("javaee10/file/gbk_utf8.txt"), StandardCharsets.UTF_8);

        // 3.读写操作
        int len;
        char[] arr = new char[8192];
        while ((len = isr.read(arr)) != -1) {
            osw.write(arr, 0, len);
        }

        // 4.关流
        isr.close();
        osw.close();
    }
}
