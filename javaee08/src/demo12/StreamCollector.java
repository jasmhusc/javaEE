package demo12;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流本身不保存数据
 * 需要将Stream操作后的数据重新存储到集合或数组中(收集数据)
 * <p>
 * 1.如何将Stream流结果收集到集合中
 * stream.collect(Collectors.toList());
 * stream.collect(Collectors.toSet());
 * <p>
 * 2.如何将Stream流结果收集到数组中
 * stream.toArray();
 */
public class StreamCollector {
    public static void main(String[] args) {
        // 创建Stream
        Stream<String> stream = Stream.of("jeorge", "kobe", "wade", "averson", "jordan");

        // Array
//        Object[] array = stream.limit(4).skip(1).toArray();

        //IllegalStateException: stream has already been operated upon or closed
        // list
        /*List<String> list = stream.filter(s -> s.endsWith("e")).collect(Collectors.toList());
        list.forEach(System.out::println);*/

        // set
        Set<String> set = stream.filter(s -> s.startsWith("j")).collect(Collectors.toSet());
        set.forEach(System.out::println);
    }
}
