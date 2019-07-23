package homework10;

public class PersonConsumer extends Thread {
    // 将锁对象传进来
    private Person person;

    public PersonConsumer(Person person) {
        this.person = person;
    }

    // 重写run方法

    @Override
    public void run() {
        // 一直运行
        while (true) {
            // 同步代码块加锁对象person
            synchronized (person) {
                if (person.getGender() == null) {
                    try {
                        person.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费：" + person);
                person.setName(null);
                person.setGender(null);
                person.notify();
            }
        }
    }
}
