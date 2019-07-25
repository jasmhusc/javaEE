package com.hsc.demo6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderDemo2 {
    public static void main(String[] args) throws IOException {
        // 按gbk读取gbk文件
        InputStreamReader isr = new InputStreamReader(new FileInputStream("javaee10/file/out_gbk.txt"), "gbk");

        //按gbk读取
        int len;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }

        // 关流
        isr.close();
    }
}
