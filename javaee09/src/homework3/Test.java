package homework3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("javaee09/file/cont.txt");
        long num = numOfChar(file, '3');
        System.out.println("数量为： " + num);
    }

    private static long numOfChar(File file, Character c) throws IOException {
        // 控制判断
        if (null == file || !file.exists())
            return 0;

        // 测试某个字符出现的次数
        FileReader fr = new FileReader(file);
        int num = 0;
        int b;
        while ((b = fr.read()) != -1) {
            if (b == c)
                num++;
        }
        fr.close();
        return num;
    }
}
