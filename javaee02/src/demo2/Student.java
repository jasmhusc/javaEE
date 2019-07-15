package demo2;

public class Student implements Smokeable,Jokerable {

    @Override
    public void joker() {
        System.out.println("I Can Play Joker!");
    }

    @Override
    public void smoke() {
        System.out.println("I Can smoke!");
    }
}
