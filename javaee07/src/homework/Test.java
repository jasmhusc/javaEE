package homework;

public class Test {
    public static void main(String[] args) {
        // 创建3个线程，分别计算10，8，5的阶乘
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("5的阶乘：  " + plus(5));
            }
        }, "线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("8的阶乘：  " + plus(8));
            }
        }, "线程2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("10的阶乘：  " + plus(10));
            }
        }, "线程3").start();

    }

    public static int plus(int n) {
        if (n == 1)
            return 1;
        System.out.println(Thread.currentThread() + ":    " + n);
        return n * plus(n - 1);
    }
}
