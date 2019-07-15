package demo5;

public class Test {
    public static void main(String[] args) {
        //不能直接创建抽象类对象,即便其中没有抽象方法。
//        new Employee();
        /*
        父类无参构造方法
        管理公司事务
        --------------------------
        父类有参构造方法
        管理公司事务
        */
        new Manager().work();
        System.out.println("--------------------------");
        new Manager("Gosling",20000).work();
    }
}
