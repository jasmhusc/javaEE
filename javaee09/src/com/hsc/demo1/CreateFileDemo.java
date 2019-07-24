package com.hsc.demo1;

import java.io.File;
import java.io.IOException;

/**
 * File文件的创建：
 * 1.创建文件file：file.createFile()
 * 2.创建文件夹file：file.mkdir()   只能创建单级目录
 * 3.创建文件夹file：file.mkdirs()  可以创建多级目录
 */
public class CreateFileDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建文件：createFile()
        File file = new File("F:/myjavafile", "newfile.txt"); // 指定要创建的目录
        boolean b = file.createNewFile(); // 创建文件
        System.out.println(b);  // 成功为 true

        // 2.创建文件夹：mkdir()   只能创建单级目录
        File dir1 = new File("F:/myjavafile/dir1");
        boolean b1 = dir1.mkdir();
        System.out.println(b1);

        // 3.创建文件夹：mkdirs()  可以创建多级目录
        File dirs = new File("F:/myjavafile/dirs/aa/a.txt");
        boolean b2 = dirs.mkdirs();
        System.out.println(b2);
    }
}
