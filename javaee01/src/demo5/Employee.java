package demo5;

public abstract class Employee {
    /*
    * 1.抽象类中不必须有抽象方法;
    * 2.抽象方法必须写在抽象类中;
    * 3.抽象类可以含有构造方法，但不能直接创建对象;
    * 4.抽象类中的抽象方法调用必须通过子类创建，子类必须重写父类所有抽象方法。
    * */
    private String name;
    private double salary;

    public Employee(){
        System.out.println("父类无参构造方法");
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        System.out.println("父类有参构造方法");
    }

    public abstract void work();
}
