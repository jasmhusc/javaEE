package com.hsc.demo2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties特有方法：
 * <p>
 * 保存数据:
 * void store​(OutputStream out, String comments) 将Properties中的键值对数据保存到文件
 * OutputStream out: 字节输出流
 * String comments: 往文件写注释内容
 * <p>
 * 可以直接对.properties文件进行写入，中文除外。
 */
public class PropStore {
    public static void main(String[] args) throws IOException {

        // 创建properties
        Properties pp = new Properties();

        // 往properties存储数据
        pp.setProperty("姓名", "孙杨");
        pp.setProperty("年龄", "28");
        pp.setProperty("职业", "游泳");

        // 调用store写入流中
        FileOutputStream fos = new FileOutputStream("javaee10/file/info.properties");
        pp.store(fos, "游泳健将名单");

        // 关流
        fos.close();
    }
}
