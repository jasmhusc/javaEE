package demo7;

import java.util.Objects;

public class Ticket1 implements Runnable {
    //  创建一个锁对象
    private Object obj = new Object();
    // 票数150
    private int tickets = 100;
    // 外界传一个锁
    private Object object;

    public Ticket1(Object object) {
        // 构造函数接收这个锁对象
        this.object = object;
    }

    @Override
    public void run() {
        // 服务窗口一直打开
        while (true) {
            // 锁对象：obj
//            synchronized (obj){
            // 外界传过来的锁对象
            synchronized (object) {
                // 锁对象：.class
//            synchronized (Ticket1.class){
                if (tickets > 0) {
                    // 买票需要150ms
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    // 执行买票
                    System.out.println(Thread.currentThread().getId() + ":    " + (tickets--));
                }
            }
        }
    }
}
