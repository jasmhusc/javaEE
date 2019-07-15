package demo3;

public class Test {
    public static void main(String[] args) {
        new StaticDemo();
        System.out.println("------------------------------");
        new StaticDemo("李蕾",23);
    }
        /*
        静态代码块
        匿名代码块1
        匿名代码块2
        无参构造
        ------------------------------
        匿名代码块1
        匿名代码块2
        有参构造*/
    }
