package demo7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1_ReenTrantLock {

    public static void main(String[] args) {
        final printer p = new printer();

        new Thread("线程1：") {
            public void run() {  // run方法的异常只能处理
                while (true) {
                    try {
                        p.printer1();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread("线程2：") {
            public void run() {
                while (true) {
                    try {
                        p.printer2();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread("线程3：") {
            public void run() {
                while (true) {
                    try {
                        p.printer3();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}


class printer {
    private int flag = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition c1 = lock.newCondition(); // 每个线程放一个监视器
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    public void printer1() throws InterruptedException {
        lock.lock();
        if (flag != 1)
            c1.await();
        System.out.print("东");
        System.out.print("方");
        System.out.print("不");
        System.out.print("败");
        System.out.print("\r\n");
        flag = 2;
        c2.signal();
        lock.unlock();
    }

    public void printer2() throws InterruptedException {
        lock.lock();
        if (flag != 2)
            c2.await();
        System.out.print("迈");
        System.out.print("克");
        System.out.print("尔");
        System.out.print("乔");
        System.out.print("丹");
        System.out.print("\r\n");
        flag = 3;
        c3.signal();
        lock.unlock();


    }

    public void printer3() throws InterruptedException {
        lock.lock();
        if (flag != 3)
            c3.await();
        System.out.print("i");
        System.out.print("c");
        System.out.print("o");
        System.out.print("u");
        System.out.print("r");
        System.out.print("s");
        System.out.print("e");
        System.out.print("\r\n");
        flag = 1;
        c1.signal();
        lock.unlock();
    }
}
