package demo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo3_executors {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());     // 将线程放进线程池

        pool.shutdown();   // 关闭线程池

    }

}
