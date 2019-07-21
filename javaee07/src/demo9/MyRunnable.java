package demo9;

import java.util.Random;

public class MyRunnable implements Runnable {
    // 10个整数求和sum
    private int n = 10;
    private int sum = 0;

    @Override
    public void run() {
        while (n > 0) {
            int i = new Random().nextInt(1000) + 100;
            System.out.println(Thread.currentThread().getName() + ":     " + i);
            sum += i;
            n--;
            Thread.yield();
        }
        System.out.println("和：  " + sum);
    }
}
