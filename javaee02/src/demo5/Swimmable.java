package demo5;

public interface Swimmable {
    // 私有方法
    static void test01() {
        System.out.println("我是接口私有方法");
    }

    // 1.私有方法给本接口的默认方法使用
    public default void show1() {
        test01();
    }

    // 2.私有方法给本接口的静态方法使用
    public static void show2() {
        test01();
    }
}
