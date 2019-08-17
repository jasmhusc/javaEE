package com.hsc.servletcontext;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class ClassPath {
    public static void main(String[] args) throws IOException {

        // 读取文件person.properties
        Properties p = new Properties();
        URL url = ClassPath.class.getResource("");
        System.out.println("url = " + url);

        // 获取输入流
        InputStream in = ClassPath.class.getResourceAsStream("/person.properties");
        p.load(in);

        // 获取数据
        Enumeration<?> enumeration = p.propertyNames();
        while (enumeration.hasMoreElements()) {
            String value = (String) enumeration.nextElement();
            System.out.println("value = " + value);
        }
    }
}
