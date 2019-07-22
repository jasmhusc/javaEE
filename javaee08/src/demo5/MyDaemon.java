package demo5;

public class MyDaemon {
    public static void main(String[] args) {
        // 创建线程t1,t2
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("小明");
        t2.setName("小王");

        // 设置守护线程
        t1.setDaemon(true);
        t2.setDaemon(true);

        // 开启线程
        t1.start();
        t2.start();

        // 设置主线程
        // 主线程退出后，子线程也随之退出，但存在延迟
        Thread.currentThread().setName("校花");
        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName() + "   " + i);
        }
    }
}
