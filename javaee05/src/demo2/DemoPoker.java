package demo2;

import java.util.*;

public class DemoPoker {
    private static Hashtable<Integer, String> pokers;
    private static ArrayList<Integer> list;

    public static void main(String[] args) {
        // 创建一副牌
        pokers = new Hashtable<>();
        list = new ArrayList<>();
        pokers.put(0, "大🃏");
        list.add(0);
        pokers.put(1, "小🃏");
        list.add(1);
        String[] colors = new String[]{"♠", "♥", "♣", "♦"};
        String[] numbers = new String[]{"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        int i = 2;
        for (String number : numbers) {
            for (String color : colors) {
                pokers.put(i, new StringBuilder().append(color).append(number).toString());
                list.add(i);
                i++;
            }
        }

        // 洗牌 (洗的是索引)

        Collections.shuffle(list);

        // 发牌
        TreeSet<Integer> GaoJin = new TreeSet<>();
        TreeSet<Integer> LongWu = new TreeSet<>();
        TreeSet<Integer> StephenChow = new TreeSet<>();
        TreeSet<Integer> Rest = new TreeSet<>();
        for (int j = 0; j < list.size(); j++) {
            Integer a = list.get(j);
            if (j >= list.size() - 3) {
                Rest.add(a);
            } else if (j % 3 == 0) {
                GaoJin.add(a);
            } else if (j % 3 == 1) {
                LongWu.add(a);
            } else if (j % 3 == 2) {
                StephenChow.add(a);
            }
        }

        lookPokers(GaoJin, "高进");
        lookPokers(LongWu, "龙五");
        lookPokers(StephenChow, "周星驰");
        lookPokers(Rest, "底牌");
    }

    public static void lookPokers(TreeSet<Integer> list, String name) {
        // 看牌
        System.out.print(name + ": ");
        for (Integer g : list) {
            String s = pokers.get(g);
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
