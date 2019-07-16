package demo7;

/**
 * 定义实现类时指定泛型, 创建对象时就不需要指定泛型
 */
public class Student implements Singable<String> {
    @Override
    public void sing(String s) {
        System.out.println(s);
    }
}
