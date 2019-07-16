package demo6;

public class TestCar {
    public static void main(String[] args) {
//      构造函数传入Person对象
        Person tang = new Person("唐三藏");
        Car<Person> personCar = new Car<Person>(tang);

//      set方法传入 Pig  对象
        Pig pig = new Pig("二师兄");
        Car<Pig> pigCar = new Car<>();
        pigCar.setCar(pig);

    }
}
