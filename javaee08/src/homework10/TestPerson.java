package homework10;

public class TestPerson {
    public static void main(String[] args) {
        // 开启2条线程
        Person p = new Person();
        new PersonProducer(p).start();
        new PersonConsumer(p).start();
    }
}
