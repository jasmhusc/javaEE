package demo8;

public class Fruit {
    public void show() {
        System.out.print("I am a kind of fruit! ");
    }
}

class Apple extends Fruit {
    @Override
    public void show() {
        super.show();
        System.out.println("I am an Apple!");
    }
}

class Orange extends Fruit {
    @Override
    public void show() {
        super.show();
        System.out.println("I am an Orange!");
    }
}