package demo7;

import java.util.TreeSet;

public class Cinema1 {
    public static void main(String[] args) {

        // 创建1个线程任务, 随便给一个锁对象, 所有线程都拥有同一把锁
        Ticket1 r = new Ticket1(new TreeSet<String>());

        // 创建3个线程卖票并且开启
        new Thread(r, "窗口1").start();
        new Thread(r, "窗口2").start();
        new Thread(r, "窗口3").start();
    }
}
