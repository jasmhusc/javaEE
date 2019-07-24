package com.hsc.demo1;

import java.io.File;

/*
 * File(String pathname)   根据一个路径得到File 对象
 * File(String parent,String child)  根据一个父目录和一个子目录/文件 得到  File 对象
 * File(File parent,String child)  根据父File 对象和子文件得到 File 对象
 * */
public class FileDemo {
    public static void main(String[] args) {

        // 1.File(File payhname)
//        File file1 = new File("F:\\myjavafile");
        File file1 = new File("F:/myjavafile");
        System.out.println(file1);

        // 2.File(String father, String son)
        File file2 = new File("F:/myjavafile", "a.txt");
        System.out.println(file2);

        // 3.File(File father,String son)
        File file3 = new File(file1, "a.txt");
        System.out.println(file3);
    }
}

