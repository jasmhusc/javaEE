package demo8;

public class Ticket implements Runnable {
    private static int poll = 100;

    @Override
    public void run() {
        while (true) {
             /*同步方法，锁对象为this
                1. 非静态方法：谁调用这个方法，锁对象就是谁
                2. 静态方法： 锁对象是当前方法所在类的字节码对象(类名.class)
             */
//            sellTicket();
            sellTicket2();
        }
    }

    private synchronized void sellTicket() {
        if (poll > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":  " + poll);
            poll--;
        }
    }

    private static synchronized void sellTicket2() {
        // poll也必须为 static
        if (poll > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":  " + poll);
            poll--;
        }
    }
}
