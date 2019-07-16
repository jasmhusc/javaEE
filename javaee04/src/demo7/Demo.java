package demo7;

/**
 * 1.泛型接口的格式?
 * interface 接口名<E> {
 * public abstract 返回值类型 方法名(E 变量名);
 * }
 * <p>
 * 2.泛型接口的使用?
 * 1.定义实现类时指定泛型, 创建对象时就不需要指定泛型
 * 2.定义实现类时,接着使用泛型, 创建对象时,就需要指定泛型
 */
public class Demo {
    public static void main(String[] args) {

        Student s = new Student();
        s.sing("我会唱歌！");

//        常用
        Bird<Integer> bird = new Bird<>();
        bird.sing(666);
    }

}
