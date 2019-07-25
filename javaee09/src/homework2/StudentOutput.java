package homework2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 从控制台循环接收用户录入的学生信息，输入格式为：学号-学生名字
 * 将学生信息保存到C盘下面的stu.txt文件中，一个学生信息占据一行数据。
 * 当用户输入end时停止输入。
 * * 要求使用字节输出流写出数据
 */
public class StudentOutput {
    public static void main(String[] args) throws IOException {

        // 键盘录入--输入流
        Scanner sc = new Scanner(System.in);
        // 文本关联--输出流
        FileOutputStream fos = new FileOutputStream("javaee09/file/stu.txt", true);

        // 提示语
        System.out.println("请录入的学生信息，输入格式为：学号-学生名字，输入‘end’退出：");
        // 循环
        while (true) {
            String s = sc.nextLine();
            if ("end".equals(s)) {
                fos.close();
                break;
            }
            fos.write(s.getBytes());
            fos.write("\r\n".getBytes());
            fos.flush();
        }
    }
}
