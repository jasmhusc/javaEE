package com.hsc.demo8;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字符流专门用于方便的操作字符的
 * Reader: 字符输入流的父类
 * int read​() 读一个字符, 返回值是读取到的字符
 * int read​(char[] cbuf) 将字符读入数组,返回读取的字符数量
 * <p>
 * 子类FileReader:
 * FileReader​(String fileName) 创建一个新的 FileReader 读取指定文件中的字符
 * FileReader​(File file) 创建一个新的 FileReader 读取指定文件中的字符
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        // 读取文本文件
        FileReader fr = new FileReader("javaee09/file/a8.txt");
        int len;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            // 将读到的字符数组输出
//            System.out.println(chars); 输出会有多余的空字符
            System.out.println(new String(chars, 0, len));
        }
        // 关流
        fr.close();
    }
}
