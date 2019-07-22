package demo2;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

public class Lambda3 {
    /*
     * 1. Iterable接口中定义了默认方法  ：
     *        1.实现或继承该接口的子类或子接口，如Collection, 可以进行：迭代器方式的遍历；
     *        2.default void forEach(Consumer<? super T> action)
     *              T为iterable中的元素类型，希望在Consumer中以上面类型接收T，处理T，泛型就写上面类型，但必须是T或T的父类；
     *        3.Consumer accept(T)   函数接口，对T类型元素执行操作，无返回值；
     *        4.forEach函数对Iterable的每个元素执行给定的操作，直到所有元素都被处理或动作引发异常。
     *
     * 2. Collection 接口是Iterable的子接口，因此可以直接使用该方法。
     */
    public static void main(String[] args) {
        // Consumer本身就是一个函数式接口
        Consumer<Person> c = p -> System.out.println(p.getName() + p.getAge());
        c.accept(new Woman("张雨绮", 27));
        System.out.println("-------------");

        // Collection 接口是Iterable的子接口，因此可以直接使用forEach()
        Collection<Woman> col = new HashSet<>();
        col.add(new Woman("张雨绮", 27));  // T = Woman
        col.add(new Woman("李小璐", 18));
        col.add(new Woman("刘岩", 24));
        col.add(new Woman("张馨予", 22));

        // 1. 普通方式遍历
        for (Woman w : col) {
            System.out.println(w.getName() + w.getAge());
        }
        System.out.println("-------------");

        // 1. 创建 Consumer 对象方式遍历
        col.forEach(new Consumer<Person>() {  // ? super T
            @Override
            public void accept(Person p) {
                System.out.println(p.getName() + p.getAge());
            }
        });
        System.out.println("-------------");

        // 3. Lambda表达式遍历
        col.forEach(p -> System.out.println(p.getName() + p.getAge()));
        System.out.println("-------------");

        // 4. 双冒号遍历---类名：：方法名  没有()
        col.forEach(System.out::println);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Woman extends Person {

    public Woman(String name, int age) {
        super(name, age);
    }
}