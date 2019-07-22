package demo12;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 方法名     方法作用        方法种类        是否支持链式调用
 * count       统计个数        终结               否
 * forEach     逐一处理        终结               否
 * filter      过滤           函数拼接            是
 * limit       取用前几个      函数拼接            是
 * skip        跳过前几个      函数拼接            是
 * map         映射           函数拼接            是
 * concat      组合           函数拼接            是
 */
public class StreamDemo {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("paul");
        list.add("james");
        list.add("wade");
        list.add("bosh");
        list.add("athony");

        /*filter,limit,skip,map,coincat为函数拼接方法
        count,forEach为终结方法，一个Stream只能且必须执行一次
        */
        // 获得名字长度为4的数量
        long count = list.stream().filter(s -> s.length() == 4).count();
        System.out.println(count);

        // 获得詹韦组合，打印输出
        list.stream().filter(s -> s.contains("a")).skip(1).limit(2).forEach(System.out::println);

        // 获得热火三巨头并映射为Player对象
        Stream<Player> playerStream = list.stream().skip(1).limit(3).map(Player::new);
        playerStream.forEach(System.out::println);

    }
}
