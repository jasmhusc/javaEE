package demo10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*创建线程池:
    Executors类:
        static ExecutorService newFixedThreadPool​(int nThreads) 创建一个具有固定数量的线程的线程池
        int nThreads:线程池中线程的数量
        ExecutorService:就是线程池*/
public class DemoThreadPool {
    public static void main(String[] args) {

        // 1.创建线程池，给定线程数量3
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 4.创建实现类对象
        MYRunnable mr = new MYRunnable();

        // 5.提交Runnable任务5个，由3条线程执行
        pool.submit(mr);
        pool.submit(mr);
        pool.submit(mr);
        pool.submit(mr);
        pool.submit(mr);

        // 6.关闭线程池(工作中建议不要做)
        pool.shutdown();
    }
}
