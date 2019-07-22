package demo12;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream中: 静态方法
 * static Stream concat​(Stream<T> a, Stream<T> b) 将两个流合并成一个流
 */
public class StreamConcat {
    public static void main(String[] args) {

        // 创建stream1
        Stream<String> stream1 = Stream.of("jeorge", "kobe", "wade", "averson", "jordan");

        //创建stream2
        Stream<String> stream2 = Stream.of("james", "jonhson", "wade", "averson");

        // concat拼接, 有重复元素
        Stream.concat(stream1, stream2).collect(Collectors.toSet()).forEach(System.out::println);
    }
}
