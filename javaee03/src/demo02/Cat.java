package demo02;

public class Cat extends Animal {
    @Override
    public void eat() {

        System.out.println("Cat: I can eat!");
    }

    public void catchMouse() {
        System.out.println("Cat: I can catch mouse!");
    }
}
