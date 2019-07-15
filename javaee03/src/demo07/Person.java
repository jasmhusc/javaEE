package demo07;

public class Person {

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("匿名代码块1");
    }

    public Person() {
        System.out.println("无参构造函数");
    }

    {
        System.out.println("匿名代码块2");
    }
}
