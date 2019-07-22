package demo2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
 * iterator.forEachRemaining方法，同Iterable接口forEach方法
 */
public class Lambda4 {
    public static void main(String[] args) {

        Collection<String> c = new HashSet<>();
        c.add("西门庆");
        c.add("潘金莲");
        c.add("武松");

        Iterator<String> it = c.iterator();
        it.forEachRemaining(System.out::println);
    }
}
