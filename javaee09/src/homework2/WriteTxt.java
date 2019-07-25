package homework2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 请用户从控制台输入信息，程序将信息存储到文件Info.txt中。可以输入多条信息，每条信息存储一行。当用户输
 * 入：”886”时，程序结束。
 */
public class WriteTxt {
    public static void main(String[] args) throws IOException {

        // 键盘录入--输入流
        Scanner sc = new Scanner(System.in);
        // 文本关联--输出流
        FileWriter fw = new FileWriter("javaee09/file/writetxt.txt", true);

        // 提示语
        System.out.println("请输入文字，输入‘886’退出：");
        // 循环
        while (true) {
            String s = sc.nextLine();
            if ("886".equals(s)) {
                fw.close();
                break;
            }
            fw.write(s);
            fw.write("\r\n");
            fw.flush();
        }
    }
}
