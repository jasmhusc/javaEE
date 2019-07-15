package demo07;

/**
 * 1.先输出语句；
 * 2.new Person() 时会加载类，执行静态代码块 static，且只执行一次；
 * 3.匿名代码块（实例代码块）是从构造函数中抽取出来的，所以匿名代码块按顺序执行；
 * 4.最后是构造函数代码执行；
 * 5.对象创建完毕，执行后续代码。
 */
public class Demo7 {
    public static void main(String[] args) {

        System.out.println("输出语句1");
        new Person();
        System.out.println("输出语句2");
        new Person();
        System.out.println("输出语句3");
    }
}
