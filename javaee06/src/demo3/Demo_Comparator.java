package demo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Comparator是一个接口:
 * Collections工具类中
 * static <T> void sort​(List<T> list, Comparator<? super T> c)
 * 根据指定的排序规则来对集合中的数据进行排序
 */
public class Demo_Comparator {
    public static void main(String[] args) {

        Player cmqz = new Player("赤木晴子", 17, 99);
        Player lcf = new Player("流川枫", 18, 9);
        Player ymhd = new Player("樱木花道", 17, 10);

        ArrayList<Player> list = new ArrayList<>();

        // 添加元素
        Collections.addAll(list, ymhd, lcf, cmqz);

        // 排序
        Collections.sort(list, new PlayerComparator());

        // 查看结果
        System.out.println(list);

        /*
            匿名内部类创建比较器
         */
        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return (int) (o2.getScore() - o1.getScore());
            }
        });

        // 查看结果
        System.out.println(list);
    }
}
