package com.hsc.demo8;

import java.io.*;

/**
 * Java 提供了一种对象序列化的机制。用一个字节序列可以表示一个对象，该字节序列包含该 对象的数据 、 对象的类型
 * 和 对象中存储的属性 等信息。字节序列写出到文件之后，相当于文件中持久保存了一个对象的信息。
 * <p>
 * public final void writeObject (Object obj) : 将指定的对象写出, utf-8编码，但是经过压缩，看不懂。
 */
public class SerializeDemo {
    public static void main(String[] args) {
        // 创建对象
        Employee e = new Employee("林俊杰", 28, "新加坡");

        // 指定保存路径
        File file = new File("javaee10/file/serial.txt");

        // 序列化
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ) {
            // 写入对象
            oos.writeObject(e);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
