package demo02;

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("Dog: I can eat!");
    }

    public void lookHome() {
        System.out.println("Dog: I can lookHome!");
    }
}
