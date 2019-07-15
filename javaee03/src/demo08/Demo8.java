package demo08;

import java.util.Objects;

/**
 * 测试 hashcode(), toString(), equals()
 * 重写用：alt + insert
 */
public class Demo8 {
    public static void main(String[] args) {

        Student s = new Student();
        Student ss = new Student("李白", 27);
        System.out.println(s.equals(ss));
        /*
         * 工具类Objects:
         *   不会报出 NullPointerException
         *   会进行 if 判断
         * */
        Student s1 = null;
        System.out.println(Objects.equals(s1, ss));
    }
}
