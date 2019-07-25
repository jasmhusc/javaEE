package com.hsc.demo2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * void load​(InputStream inStream) 从流中加载数据到Properties中
 */
public class PropLoad {
    public static void main(String[] args) throws IOException {

        // 创建properties
        Properties pp = new Properties();

        // load数据
        FileInputStream fis = new FileInputStream("javaee10/file/info.properties");
        pp.load(fis);

        // 打印输出
        System.out.println(pp);
    }
}
