package demo3;

public class StaticDemo {
    /**
     * 1.调用静态代码块，且只在类第一次加载时调用一次;
     * 2.调用匿名代码块，按顺序调用;
     * 3.调用构造函数。
     */
    private String name;
    private int age;

    public StaticDemo() {
        System.out.println("无参构造");
    }

    public StaticDemo(String name, int age) {
        System.out.println("有参构造");
        this.name = name;
        this.age = age;
    }

    {
        System.out.println("匿名代码块1");
    }
    {
        System.out.println("匿名代码块2");
    }
    static {
        System.out.println("静态代码块");
    }
}
