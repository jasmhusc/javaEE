package com.hsc.demo2;

import java.io.File;

/*
    路径是否存在：exists
    得到路径名： getName
    能读，能写：canRead canWrite
    相对路径：getPath
    绝对路径：getAbsolutePath
    字节长度: length （文件夹都为0）
    是否隐藏: isHidden
    得到路径下所有文件名String: list
    得到路径下所有文件File: listFiles
    ... ...
 */
public class ExistFile {
    public static void main(String[] args) {
        // 是否存在
        File file = new File("F:/myjavafile");
        boolean exists = file.exists();
        System.out.println(exists); // true

        // 得到路径名
        String name = file.getName();
        System.out.println(name); // myjavafile

        // 能读？能写？
        System.out.println(file.canRead()); // true
        System.out.println(file.canWrite()); // true

        // 绝对路径
        File absoluteFile = file.getAbsoluteFile();
        System.out.println(absoluteFile); //F:\myjavafile

        // 相对路径
        String path = file.getPath();
        System.out.println(path); //F:\myjavafile

        // 字节长度
        long length = file.length();
        System.out.println(length); // 字节长度 0

        // 是否为文件file
        boolean b = file.isFile(); // false

        // 是否是文件夹
        boolean b1 = file.isDirectory(); // true

        // 是否隐藏
        boolean b2 = file.isHidden(); // false

        // 得到路径下所有文件名
        String[] list = file.list();

        // 得到路径下所有文件File
        File[] files = file.listFiles();

        // 得到父路径名
        File son = new File("F:/myjavafile/dir1");
        String parent = son.getParent(); //F:\myjavafile

        // 得到父路径File
        File parentFile = son.getParentFile();

        // 对read, write, execute, lastModified进行设置
        boolean b3 = son.setWritable(false); // true

        // 改名
        boolean b4 = son.renameTo(new File("F:/myjavafile/firstdir")); // true
    }
}
