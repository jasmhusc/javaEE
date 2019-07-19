package demo3;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    // 返回的是int类型，实现Comparator要指定泛型
    @Override
    public int compare(Player o1, Player o2) {

        // 比较学生年龄: o1 - o2升序
        // return o1.getAge() - o2.getAge();
        // 比较学生年龄: o2 - o1降序
        // return o2.getAge() - o1.getAge();
        return (int) (o1.getScore() - o2.getScore());
    }
}
