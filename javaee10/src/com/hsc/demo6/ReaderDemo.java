package com.hsc.demo6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader​(InputStream in) 使用默认的UTF-8
 * InputStreamReader​(InputStream in, String charsetName) 使用指定的字符集
 * <p>
 * 真正操作文件靠的参数的基本流,转换流负责将读取到的数据去查码表转成对应文字
 */
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        // 字符流读取GBK编码的文本文件
        InputStreamReader isr = new InputStreamReader(new FileInputStream("javaee10/file/out_gbk.txt"));
        //InputStreamReader isr = new InputStreamReader(new FileInputStream("javaee10/file/out_utf8.txt"));

        // 默认按utf-8读取，也可以指定编码读取
        int len;
        char[] chs = new char[1024];
        while ((len = isr.read(chs)) != -1) {
            System.out.println(new String(chs, 0, len));
            // ����������g4r�죬/r/n���˲�û�к�һЩ��/r/n��ʻ�ڹ�·�޼��ޱߣ�/r/n���뿪�Լ��ĸо���/r/n
        }

        // 关流
        isr.close();
    }
}
