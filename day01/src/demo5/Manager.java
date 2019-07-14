package demo5;

public class Manager extends Employee{
    /**
     * 抽象方法在调用之前，必须被重写;
     * 父类中非抽象的方法也可以在子类中重写。
     */
    public Manager() {
        super();
    }

    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println("管理公司事务");
    }
}
