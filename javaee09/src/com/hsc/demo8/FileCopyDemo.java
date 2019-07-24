package com.hsc.demo8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyDemo {
    public static void main(String[] args) throws IOException {
        // 读取本java文件，并写出到file文件夹
        FileReader fr = new FileReader("javaee09/src/com/hsc/demo8/FileReaderDemo.java");
        FileWriter fw = new FileWriter("javaee09/file/copy8.java");
        int len;
        char[] charArr = new char[1024];
        while ((len = fr.read(charArr)) != -1) {
            fw.write(charArr, 0, len);
            fw.flush();
        }

        // 关流
        fr.close();
        fw.close();
    }
}
