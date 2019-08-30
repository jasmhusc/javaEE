package com.hsc.demo8;

import java.io.*;
import java.util.ArrayList;

/**
 * 练习：
 * 1. 将存有多个自定义对象的集合序列化操作，保存到 list.txt 文件中。
 * 2. 反序列化 list.txt ，并遍历集合，打印对象信息。
 */
public class SerTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("javaee10/file/list.txt");
        serialList(file);
        derialList(file);
    }

    private static void derialList(File file) throws IOException, ClassNotFoundException {
        // 3. 反序列化读取时，只需要读取一次，转换为集合类型。
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ArrayList list = (ArrayList) ois.readObject();
        ois.close();

        // 4. 遍历集合，可以打印所有的学生信息
        list.forEach(System.out::println);
    }

    private static void serialList(File file) throws IOException {
        // 1. 把若干学生对象 ，保存到集合中。
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("樱木花道",18,"湘北"));
        list.add(new Employee("流川枫",19,"湘北"));
        list.add(new Employee("仙道",17,"凌南"));
        list.add(new Employee("赤木晴子",16,"湘北"));

        // 2. 把集合序列化。
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(list);
        oos.close();
    }
}
