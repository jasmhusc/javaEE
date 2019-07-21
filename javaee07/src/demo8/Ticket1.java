package demo8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket1 implements Runnable {

    private int poll = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (poll > 0) {
                try {
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + ":    " + poll--);
                // 礼让线程，尽量让cpu切换到另一个线程
                Thread.yield();
            }
            lock.unlock();
        }
    }
}
