package com.hsc.demo3;

import java.io.File;
import java.io.IOException;

/*
    idea的相对路径参考：F:\idea\javaEE\
    目录放在project目录下
 */
public class PathDemo {
    public static void main(String[] args) throws IOException {
        // idea相对路径
        // F:\idea\javaEE\.gitignore
        File file = new File(".gitignore");
        System.out.println(file.getAbsolutePath());

        // 在相对路径下新建文件
        File file1 = new File("a.txt");
        System.out.println(file1.createNewFile()); // true
    }
}
