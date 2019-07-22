package demo11;

import java.time.Clock;
import java.util.*;
import java.util.stream.Stream;

/**
 * 1.Collection的方法:
 * Stream<E> stream​() 得到集合的Stream流
 * <p>
 * 2.Stream类的静态方法:
 * static Stream of​(T... values)
 * 可变参数本质是数组，也可以传入数组，但必须是引用类型，基本类型不可以
 */
public class StreamDemo {
    public static void main(String[] args) {
        // list
        List<String> list = new ArrayList<>();
        Stream<String> streamList = list.stream();

        // set
        Set<Integer> set = new TreeSet<>();
        Stream<Integer> streamSet = set.stream();

        // map
        HashMap<String, Clock> map = new HashMap<>();
        Set<Map.Entry<String, Clock>> entries = map.entrySet();
        Stream<Map.Entry<String, Clock>> streamEntry = entries.stream();
        // map 分别获取
        Stream<String> streamKey = map.keySet().stream();

        // static Stream of​(T... values)
        Stream<String> stream = Stream.of("aa", "bbb", "ccc");

        //数组
        Stream<double[]> streamArr = Stream.of(new double[]{1, 2, 3, 4});

        // 基本类型不可以
    }
}
