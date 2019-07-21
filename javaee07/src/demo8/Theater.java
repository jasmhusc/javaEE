package demo8;

public class Theater {

    public static void main(String[] args) {
//        demo1();
        // 创建3个线程，测试同步方法
        Ticket1 r = new Ticket1();

        new Thread(r, "窗口1").start();
        new Thread(r, "窗口2").start();
        new Thread(r, "窗口3").start();
    }

    private static void demo1() {
        // 创建3个线程，测试同步方法
        Ticket r = new Ticket();

        new Thread(r, "窗口1").start();
        new Thread(r, "窗口2").start();
        new Thread(r, "窗口3").start();
    }
}
