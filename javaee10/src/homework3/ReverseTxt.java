package homework3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 利用IO流的知识读取text.txt文件的内容反转后写入reverse.txt文件中
 */
public class ReverseTxt {
    public static void main(String[] args) throws IOException {

        // 创建集合存储读到的数据
        ArrayList<String> list = new ArrayList<>();

        // 关联文件，读取数据
        BufferedReader br = new BufferedReader(new FileReader("javaee10/file/text.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();

        // 集合内容反转
        Collections.reverse(list);

        // 关联文件，写出数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("javaee10/file/reverse.txt"));
        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();

    }
}
