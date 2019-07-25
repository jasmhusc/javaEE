package homework3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 键盘录入一些数据到文本中，并保存；
 * 测试类中判断某个字符的出现次数，返回值为int
 */
public class StatisticsChar {
    public static void main(String[] args) throws IOException {

        // 创建输入流，输出流
        FileWriter fw = new FileWriter("javaee09/file/cont.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 录入数据
        System.out.println("输入文本内容（886表示退出）：");
        while (true) {
            String line = br.readLine();
            if ("886".equals(line))
                break;
            fw.write(line);
            fw.write("\r\n");
        }

        // 关流
        br.close();
        fw.close();
    }
}
