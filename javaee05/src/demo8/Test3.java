package demo8;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test3 {
    // 键盘输入整数，直到输入 quit 时停止，并将输入的数倒叙输出

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数，输入 quit 停止输入：");
        String line = sc.nextLine();
        TreeSet<Integer> ts = new TreeSet<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer s1, Integer s2) {
                int num = s2.compareTo(s1);
                return num == 0 ? 1 : num;
            }

        });
        while (true) {

            if (!"quit".equals(line)) {
                Integer i = Integer.parseInt(line);
                ts.add(i);
                line = sc.nextLine();
            } else {
                sc.close();
                break;
            }
        }

        System.out.println(ts);

    }
}
