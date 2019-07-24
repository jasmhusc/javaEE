package com.hsc.demo8;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Writer: 字符输出流的父类
 * void write​(int c) 写一个字符
 * void write​(char[] cbuf) 写入一个字符数组。
 * void write​(char[] cbuf, int off, int len) 写入字符数组的一部分。
 * void write​(String str) 写一个字符串
 * void write​(String str, int off, int len) 写一个字符串的一部分。
 * <p>
 * 子类FileWriter​:
 * FileWriter​(String fileName) 创建一个文件字符输出流,往指定的文件写数据
 * FileWriter​(File file) 创建一个文件字符输出流,往指定的文件写数据
 */
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        // 写出文本到file
        FileWriter fw = new FileWriter("javaee09/file/a8.txt", true);

        // void write​(int c) 写一个字符
        fw.write('王');
        fw.write('强');

        // void write​(char[] cbuf) 写入一个字符数组。
        char[] chars = {'我', '想', '要', '个', '女', '同', '桌'};
        fw.write(chars);
        fw.write("\r\n");

        // void write​(char[] cbuf, int off, int len) 写入字符数组的一部分。
        fw.write(chars, 2, 4);
        fw.write("\r\n");

        // void write​(String str) 写一个字符串
        fw.write("Love中国\r\n");

        // void write​(String str, int off, int len) 写一个字符串的一部分。
        fw.write("China", 2, 2);

        // 关流
        fw.close();
    }
}
