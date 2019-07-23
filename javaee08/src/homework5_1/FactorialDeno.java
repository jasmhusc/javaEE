package homework5_1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 1. 开启三个线程，分别执行以下三个运算，并将运算结果输出到控制台。
 * 一个线程计算10!
 * 一个线程计算5!
 * 一个线程计算8!
 */
public class FactorialDeno {
    public static void main(String[] args) throws Exception {

        // 创建3条线程计算10,8,5的阶乘

        // 1.创建Callable任务
        FactorialCallable task1 = new FactorialCallable(5);
        FactorialCallable task2 = new FactorialCallable(8);
        FactorialCallable task3 = new FactorialCallable(10);

        // 2.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 3.提交任务
        Future<Integer> future1 = pool.submit(task1);
        Future<Integer> future2 = pool.submit(task2);
        Future<Integer> future3 = pool.submit(task3);

        // 4.获得结果并输出
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());

        // 5.关闭线程池
        pool.shutdown();
    }
}
