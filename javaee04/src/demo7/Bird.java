package demo7;

/**
 * @param <E> 定义实现类时,接着使用泛型, 创建对象时,就需要指定泛型
 */
public class Bird<E> implements Singable<E> {
    @Override
    public void sing(E e) {
        System.out.println(e);
    }
}
