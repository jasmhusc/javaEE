package demo2;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/*
 * Collections工具类：
 *       所有方法都为静态
 * 常用方法：
 *       1. addAll​(Collection<? super T> c, T... elements)
 *       2. copy​(List<? super T> dest, List<? extends T> src)
 *       3. shuffle​(List<?> list)
 *       4. static <T extends Comparable<? super T>> void sort​(List<T> list)
 * */
public class Demo_Collections {
    public static void main(String[] args) {

        // addAll()
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "paul", "李白", "james", "马蓉", "paul", "李白", "james", "马蓉");
        System.out.println(list);

        // shuffle
        Collections.shuffle(list);
        System.out.println(list);

        // copy
        LinkedList<String> list2 = new LinkedList<>();
        Collections.addAll(list2, "a", "c", "s", "ab", "bd");
        Collections.copy(list, list2);
        System.out.println(list);

        // sort
        Collections.sort(list);
        System.out.println(list);
    }
}
