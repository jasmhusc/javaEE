package homework4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoFactorial {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 用线程池求5，8，10阶乘
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new Task(5));
        pool.submit(new Task(8));
        Future<?> future = pool.submit(new Task(10));
        System.out.println(future.get());  // null
        pool.shutdown();
    }
}
