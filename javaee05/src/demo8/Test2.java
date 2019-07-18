package demo8;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

// 输入一个字符串，并对字符串排序，保留重复后输出
public class Test2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一行字符串：");
        String line = sc.nextLine();
        char[] arr = line.toCharArray();
        sc.close();
        // character类也和String一样，已经实现了  Comparable接口，并重写CompareTo方法，会去除重复，结果默认按照 字典排序
        TreeSet<Character> ch = new TreeSet<>(new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                int num = o1.compareTo(o2);
                // int num = o1 - o2;
                return num == 0 ? 1 : num;
            }

        });

        for (char c : arr) {
            ch.add(c);
        }

        for (Character character : ch) {
            System.out.print(character);
        }
    }

}
