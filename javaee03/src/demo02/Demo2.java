package demo02;

public class Demo2 {
    /*
     * 多态优点：提高代码的扩展性
     * 缺点：只能调用父类的方法，调用子类自己的方法需要向下转型
     * */
    public static void main(String[] args) {

//        多态调用右边子类重写方法
        Animal cat = new Cat();
        animalEat(cat);
//        cat.catchMouse(); 向下转型
        Cat c = (Cat) cat;
        c.catchMouse();

        Dog dog = new Dog();
        animalEat(dog);
        System.out.println("---------------------");
        // instanceof() 和 isTnstance()
        animalWork(cat);
        animalWork(dog);
    }

    public static void animalEat(Animal animal) {

        animal.eat();
    }

    public static void animalWork(Animal a) {

        if (a instanceof Cat) {
            Cat cat = (Cat) a;
            cat.catchMouse();
        } else if (a.getClass().isInstance(new Dog())) {
            Dog dog = (Dog) a;
            dog.lookHome();
        } else {
            System.out.println("This animal cannot work!");
        }
    }
}
