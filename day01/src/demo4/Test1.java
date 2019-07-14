package demo4;

public class Test1 {

    public static void main(String[] args) {
        Son son = new Son();
        son.swim();

        son.say();  // 可以用父类的抽象方法，但不推荐
    }

}

abstract class Father{
    public static void say(){
        System.out.println("Hi!");
    }

//    private abstract void move();   no  private和abstract不能共存
//    public static abstract void see(){}  no static和abstract不能共存
//    public final abstract void cook(){}  no  final 和 abstract不能共存
    public abstract void swim(); // yes
}

class Son extends Father{

    @Override
    public void swim() {
        System.out.println("swim...");
    }
}