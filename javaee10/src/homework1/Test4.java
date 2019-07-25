package homework1;

import java.io.*;
import java.util.Scanner;

/**
 * 分析以下需求，并用代码实现
 * 实现一个验证码小程序，要求如下：
 * 1. 在项目根目录下新建一个文件：data.txt，键盘录入3个字符串验证码，并存入data.txt中，要求一个验证码占一
 * 行；
 * 2. 键盘录入一个需要被校验的验证码，如果输入的验证码在data.txt中存在：在控制台提示验证成功，如果不存在
 * 控制台提示验证失败
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        // 只能订文件存储路径
        File file = new File("javaee10/file/data.txt");

        // 键盘录入数据
        System.out.println("请输入三个验证码：");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String s = sc.next();
            writeProofWord(file, s);
        }

        // 提示输入验证码
        System.out.println("请输入一个需要校验的验证码：");
        String next = sc.next();
        proofWords(file, next);
    }

    private static void proofWords(File file, String s) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if (s.equals(line)) {
                System.out.println("验证通过");
                br.close();
                return;
            }
        }
        System.out.println("验证失败");
        br.close();
    }

    private static void writeProofWord(File file, String s) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(s);
        bw.newLine();
        bw.close();
    }
}
