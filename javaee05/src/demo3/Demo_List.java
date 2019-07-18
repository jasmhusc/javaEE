package demo3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List接口特点:
 * 1.有索引
 * 2.存储和取出有顺序
 * 3.元素可以重复
 * 常用方法：
 * void add​(int index, E element)
 * E get​(int index)
 * E remove​(int index)
 * E set​(int index, E element)
 */
public class Demo_List {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("paul");
        list.add("james");
        list.add("paul");
        list.add("jordan");
        list.add("bryant");
        list.add("jordan");

        // 遍历输出，可重复，有索引
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.print(s + " ");
        }

        System.out.println();

        // 指定位置删除,返回被删除的元素，删除后所有元素向前移一位
        String s = list.remove(1);
        System.out.println(s);

        // 指定元素删除,只会删除第一个
        boolean b = list.remove("jordan");
        System.out.println(b);

        // 再次遍历输出查看结果
        for (String s1 : list) {
            System.out.print(s1 + " ");
        }
        System.out.println();

        // 修改指定位置元素的值，返回被修改的值
        String s2 = list.set(1, "Macgrady");
        System.out.println(s2);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
