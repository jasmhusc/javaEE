package homework;

import java.util.HashMap;
import java.util.Scanner;

public class Test_CharSum {
    public static void main(String[] args) {
        // 输入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个字符串：");
        String line = sc.nextLine();

        // 字符串转化为数组
        char[] chars = line.toCharArray();

        // 遍历数组统计,map存的就是：字符类型--数量
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch : chars) {
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                countingKey(map, "字母");
            } else if (ch == ' ') {
                countingKey(map, "空格");
            } else if (ch >= '0' && ch <= '9') {
                countingKey(map, "数字");
            } else {
                countingKey(map, "其他");
            }
        }
        System.out.println(map);
    }

    private static void countingKey(HashMap<String, Integer> map, String s) {
        if (!map.keySet().contains(s)) {
            map.put(s, 1);
        } else {
            map.put(s, map.get(s) + 1);
        }
    }
}
