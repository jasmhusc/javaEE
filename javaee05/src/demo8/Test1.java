package demo8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Test1 {
    // 对一个无序且重复的字符串集合进行排序，但保留重复

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("zz");
        al.add("hh");
        al.add("oj");
        al.add("xxx");
        al.add("hh");
        al.add("aaaa");
        al.add("hh");

        sort(al);
        System.out.println(al);

    }

    public static void sort(List<String> list) {
        // 不用String本身的，而是传入一个比较器对象，并设置自己的比较规则
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {

                int num = s1.compareTo(s2);
                return num == 0 ? 1 : num;
            }

        });
        // 把al中的对象放入 ts 内
        ts.addAll(list);
        //清空list
        list.clear();
        //将ts集合内对象放入 list
        list.addAll(ts);

    }

}
