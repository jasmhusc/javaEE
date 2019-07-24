package com.hsc.demo2;

import java.io.File;

/*
    文件的删除：delete() 不走回收站，直接删除
 */
public class DeleteFile {
    public static void main(String[] args) {
        // delete()
        File file = new File("F:/myjavafile/dirs/aa/a.txt");
        boolean b = file.delete();
        System.out.println(b); // true

        // 不能删除多级文件夹(aa还包含a.xml文件夹)
        File file1 = new File("F:/myjavafile/dirs/aa");
        boolean b1 = file1.delete();
        System.out.println(b1);
    }
}
