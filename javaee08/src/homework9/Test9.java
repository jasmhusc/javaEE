package homework9;

import java.util.*;

// 使用lambda表达式对List，Set，Map集合进行遍历。
public class Test9 {
    public static void main(String[] args) {
        // list
        List<Integer> list = Arrays.asList(3, 2, 5, 1, 3, 5, 4);
        list.forEach(System.out::println);
        System.out.println("--------");

        // set
        Set<Integer> set = new HashSet<>(list);
        set.forEach(System.out::println);
        System.out.println("--------");

        // map
        HashMap<String, Integer> map = new HashMap<>();
        map.put("李华", 85);
        map.put("刘静", 75);
        map.put("王丽", 95);
        map.forEach((n, s) -> System.out.println(n + ":    " + s));
    }
}
