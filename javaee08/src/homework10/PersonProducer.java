package homework10;

public class PersonProducer extends Thread {
    // 将锁对象传进来
    private Person person;

    public PersonProducer(Person person) {
        this.person = person;
    }

    // 重写run方法

    @Override
    public void run() {
        // 一直运行
        while (true) {
            // 同步代码块加锁对象person
            synchronized (person) {
                person.setName("harden");
                person.setGender(Gender.Mail);
                person.setFlag(true);
                System.out.println("生产： " + person);
                person.notify();
                try {
                    person.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
