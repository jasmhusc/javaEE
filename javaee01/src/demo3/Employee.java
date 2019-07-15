package demo3;
/*
* 构造函数中第一行默认为super()
* 可以将第一行写：super()或this(),二者仅能存在一个。
* 子类所有构造函数中至少有一个的第一行为super(),以保证可以调用到父类构造函数。
* 构造函数作用是进行初始化。*/
public class Employee {
    private String name;
    private int salary;

    public Employee() {
        super();
    }

    public Employee(String name, int salary) {
//        super();
        this();
        this.name = name;
        this.salary = salary;
    }
}
