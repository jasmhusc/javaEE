package homework8;

import java.util.Arrays;
import java.util.Collections;

/**
 * 1. 对Java基础班学生的考试成绩进行排序
 * 定义一个学生类，有两个属性。姓名，考试成绩
 * 在测试类中定义一个学生数组，存储学生信息。
 * 使用Lambda省略格式写法对学生数组按照考试成绩由高到低进行排序。
 */
public class TestStudent {
    public static void main(String[] args) {
        // 定义学生数组
        Student[] stus = new Student[]{new Student("李华", 86), new Student("刘晓静", 75), new Student("瓦格纳", 91)};
        // 成绩降序排列
        Arrays.stream(stus).sorted((s1, s2) -> (int) (s2.getScore() - s1.getScore())).forEach(System.out::println);
    }
}
