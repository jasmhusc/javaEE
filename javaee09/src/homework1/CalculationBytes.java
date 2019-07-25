package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 从键盘接收一个文件夹路径,获得该文件夹大小并输出到控制台。
 */
public class CalculationBytes {
    private static long size;

    public static void main(String[] args) throws FileNotFoundException {
        // 1. 创建键盘录入对象Scanner
        Scanner sc = new Scanner(System.in);

        // 2. 定义字符串接收用户输入的文件夹路径
        String path = sc.nextLine();

        // 3. 根据文件夹路径创建文件对象
        File file = new File(path);

        // 5. 调用方法
        long calu = calculation(file);
        System.out.println(file.getName() + "文件大小：" + calu + "kb");
    }

    /*
     4. 定义一个方法calculate用来计算指定文件夹的大小，接收文件参数，返回long类型数值表示文件夹的大小。
      */
    public static long calculation(File file) throws FileNotFoundException {
        if (null == file)
            throw new NullPointerException("文件路径为空！");
        if (!file.exists())
            throw new FileNotFoundException("路径错误！");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File listFile : files) {
                    calculation(listFile);
                }
            }
        } else
            size += file.length();
        return size;
    }
}
