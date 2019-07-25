package com.hsc.otherio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
 *   用于存储临时数据，用完后就清空了
 *   不用写入文件中
 *   创建 ByteArrayInputStream 对象时，需要一个“字节数组”，
 *   并且会存入其内部的缓冲区 (byte数组) 以待读取，我们可以通过 read() 方法来获取。
 */
public class ByteArray_Demo {

    public static void main(String[] args) throws IOException {

        // 临时存储在内存中，不需要指定路径
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write("HelloWorld!".getBytes());

        // 将缓存的内容专程字节数组，并读取打印。
        byte[] by = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(by);

        int len;
        while ((len = bis.read()) != -1) {

            System.out.print((char) len);
        }

        // 关流
        bos.close();
        bis.close();

    }
}
