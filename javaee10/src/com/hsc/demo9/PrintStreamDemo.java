package com.hsc.demo9;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 打印流分类:
 * 字节打印流: PrintStream
 * 字符打印流: PrintWriter
 * <p>
 * 打印流的特点:
 * 只有输出方向,没有输入方向
 * 原样输出,写什么就打印什么
 * <p>
 * PrintStream类的使用:
 * 构造方法:
 * PrintStream​(String fileName) 使用指定的文件名创建新的打印流，无需自动换行。
 * PrintStream​(File file) 使用指定的文件创建一个新的打印流，而不需要自动换行。
 * PrintStream​(OutputStream out) 创建一个新的打印流。
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {

        // 1. 创建打印流
        PrintStream ps = new PrintStream("javaee10/file/print.txt");

        // 2. 打印数据
        ps.println("java");
        ps.println(true);
        ps.print(5);
        ps.print(' ');
        ps.print('g');

        // 关流
        ps.close();
    }
}
