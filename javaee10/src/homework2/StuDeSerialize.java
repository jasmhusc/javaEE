package homework2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StuDeSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("javaee10/file/stu.txt"));
        Student s = (Student) ois.readObject();
        System.out.println(s);
        ois.close();
    }
}
