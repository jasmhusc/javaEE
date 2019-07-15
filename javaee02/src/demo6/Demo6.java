package demo6;

public class Demo6 {
    public static void main(String[] args) {
        // 创建两个对象
        SingletonDemo obj1 = SingletonDemo.getInstance();
        System.out.println(obj1.getContent());

        SingletonDemo obj2 = SingletonDemo.getInstance();
        System.out.println(obj2.getContent());

        // 单例证明
        obj2.setContent("efg");
        System.out.println(obj1.getContent());
        System.out.println(obj2.getContent());

        System.out.println(obj1==obj2);

    }
}
