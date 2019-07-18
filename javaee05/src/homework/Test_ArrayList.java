package homework;

import java.util.ArrayList;
import java.util.Iterator;

public class Test_ArrayList {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("aa", 17, 80));
        list.add(new Student("bb", 18, 90));
        list.add(new Student("cc", 19, 78));
        list.add(new Student("dd", 14, 82));
        list.add(new Student("ee", 15, 89));

        // 遍历输出学生成绩信息
        double sum = 0;
        double max = list.get(0).getScore();
        double min = list.get(0).getScore();
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            double d = it.next().getScore();
            // 统计总分
            sum += d;
            // 统计最值
            max = max > d ? max : d;
            min = min < d ? min : d;
        }
        // 平均分
        double avr = sum / list.size();

        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(avr);
    }
}
