package com.hsc.demo4;

import java.io.File;
import java.io.IOException;

/**
 * 打印目录结构
 * level:表示目录的层次
 */
public class ErgodicFile {
    public static void main(String[] args) throws IOException {

        // 用递归遍历某个目录下所有文件
        File file = new File("F:/myjavafile");
        ergodicFiles(file, 0);
    }

    // 遍历指定路径下所有的txt文件
    private static void ergodicFiles(File file, int level) {
        // 路径为空直接终止执行
        if (null == file)
            return;

        // 文件夹为空终止
        File[] files = file.listFiles();
        if (null == files)
            return;

        // 遍历，按格式打印文件
        for (File file1 : files) {
            // 打印层级
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            // 遍历，递归
            if (file1.isDirectory()) {
                System.out.println(file1.getName() + ":");
                ergodicFiles(file1, level + 1);
            } else {
                // 直接输出得到文本名称
                System.out.println(file1.getName());
            }
        }
    }
}
