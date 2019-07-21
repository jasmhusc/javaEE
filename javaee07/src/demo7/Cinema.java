package demo7;

public class Cinema {
    public static void main(String[] args) {

        //创建线程任务对象
        Ticket r = new Ticket();

        // 3个窗口在卖票
        Thread t1 = new Thread(r, "窗口1");
        Thread t2 = new Thread(r, "窗口2");
        Thread t3 = new Thread(r, "窗口3");

        // 开启3个线程
        t1.start();
        t2.start();
        t3.start();
    }
}
