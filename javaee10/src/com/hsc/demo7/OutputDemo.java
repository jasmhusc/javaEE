package com.hsc.demo7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * OutputStreamWriter​(OutputStream out) 创建一个使用默认字符编码的OutputStreamWriter
 * OutputStreamWriter​(OutputStream out, String charsetName) 创建一个使用指定字符编码的OutputStreamWriter
 * 真正操作文件靠基本流.转换流负责查询码表.
 */
public class OutputDemo {
    public static void main(String[] args) throws IOException {

        // 控制台写入数据，并以GBK写入文件out_gbk.txt
        Scanner sc = new Scanner(System.in);

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("javaee10/file/out_gbk.txt", true), "GBK");
        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("javaee10/file/out_utf8.txt",true), "utf-8");

        System.out.println("请输入要存储的信息：");
        while (true) {
            String line = sc.nextLine();
            if ("886".equals(line)) {
                osw.close();
                break;
            }
            osw.write(line);
            osw.write("\r\n");
        }

        // 关流
        osw.close();
    }
}
