package com.hsc.demo5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * OutputStream:字节输出流的父类
 * void write​(int b) 将一个字节写入流中
 * <p>
 * 子类FileOutptuStream:
 * FileOutputStream​(String name) 创建一个文件字节输出流,流中的数据会流入指定的文件中
 * FileOutputStream​(File file) 创建一个文件字节输出流,流中的数据会流入指定的文件中
 */
public class IOSingleByte {
    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    private static void read() throws IOException {
        // 单个字节读取
        FileInputStream fis = new FileInputStream("javaee09/file/a5.txt");
        int b;
        while ((b = fis.read()) != -1) {
            System.out.println((char) b);
        }

        // 关流
        fis.close();
    }

    private static void write() throws IOException {
        // 单个字符写入一串字符串：ILOVEJava！
        FileOutputStream fos = new FileOutputStream("javaee09/file/a5.txt");
        fos.write('I');
        fos.write('L');
        fos.write('O');
        fos.write('E');
        fos.write('J');
        fos.write('a');
        fos.write('v');
        fos.write('a');
        fos.write('!');

        // 关流
        fos.close();
    }
}
