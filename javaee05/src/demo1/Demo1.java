package demo1;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("paul");
        list.add("james");
        list.add("harden");
        list.add("wade");
        list.add("anthony");
        list.add("♦");
        // 迭代器遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String name = it.next();
            if ("harden".equals(name))
                // ConcurrentModificationException 并发修改异常
                //list.remove(name);
                System.out.println(name);
        }
        /**
         * 增强for循环遍历
         * 1.对于数组，底层是普通for循环
         * 2.对于集合，底层是迭代器
         */
        for (String name : list) {
            System.out.println(name);
        }
    }
}
