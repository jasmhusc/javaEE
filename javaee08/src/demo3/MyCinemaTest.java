package demo3;

public class MyCinemaTest {
    public static void main(String[] args) {
        // 创建线程对象
        MyCinema m = new MyCinema();
        Thread t1 = new Thread(m, "线程1：");
        Thread t2 = new Thread(m, "线程2：");
        Thread t3 = new Thread(m, "线程3：");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
