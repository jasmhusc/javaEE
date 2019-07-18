package homework;

import java.util.ArrayList;
import java.util.HashSet;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('f');
        list.add('b');
        list.add('c');
        list.add('a');
        list.add('d');

        HashSet<Character> set = new HashSet<>();
        set.addAll(list);
        list.clear();
        for (Character c : set) {
            list.add(c);
        }
        System.out.println(list);
    }
}
