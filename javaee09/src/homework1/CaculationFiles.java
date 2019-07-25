package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数
 * 注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,
 * 用个数作为value,放入到map集合中,并用两种方式遍历map集合
 * 例如：
 * doc 的类型的文件有 3 个
 * java 的类型的文件有 5 个
 * txt 的类型的文件有 7 个
 */
public class CaculationFiles {
    private static int num = 0;
    private static HashMap<String, Integer> map = new HashMap();

    public static void main(String[] args) throws FileNotFoundException {
        // 1. 创建键盘录入对象Scanner
        Scanner sc = new Scanner(System.in);

        // 2. 定义字符串接收用户输入的文件夹路径
        String path = sc.nextLine();

        // 3. 根据文件夹路径创建文件对象
        File file = new File(path);

        // 5. 调用方法
        HashMap filesmap = calculation(file);
        filesmap.entrySet().forEach(System.out::println);
    }

    private static HashMap calculation(File file) throws FileNotFoundException {
        if (null == file)
            throw new NullPointerException("文件路径为空！");
        if (!file.exists())
            throw new FileNotFoundException("路径错误！");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null == files)
                throw new NullPointerException("文件路径为空！");
            for (File listFile : files) {
                calculation(listFile);
            }
        } else {
            String name = file.getName();
            String[] split = name.split("[.]");
            int length = split.length;
            if (length > 1) {
                String key = split[length - 1];
                if (map.containsKey(key))
                    map.put(key, map.get(key) + 1);
                else
                    map.put(key, 1);
            }

        }
        return map;
    }
}
