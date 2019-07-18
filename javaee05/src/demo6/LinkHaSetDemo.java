package demo6;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkHaSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> link = new LinkedHashSet<>();
        link.add("刘德华");
        link.add("刘德华");
        link.add("黎明");
        link.add("张学友");
        link.add("张学友");
        link.add("郭富城");

        Iterator<String> it = link.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
