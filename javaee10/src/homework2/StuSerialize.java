package homework2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 在测试类中创建一个学生对象，给学生对象的三个成员变量赋值。
 * 然后将该对象保存到当前项目根目录下的stu.txt文件中。
 */
public class StuSerialize {
    public static void main(String[] args) throws IOException {

        // 创建对象
        Student s = new Student("樱木花道", 18, "男");

        // 系列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("javaee10/file/stu.txt"));
        oos.writeObject(s);
        oos.close();
    }
}
