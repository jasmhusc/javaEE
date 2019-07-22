package demo11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 计算1~n的和
        MyCallable mc = new MyCallable(10);
//        new Thread(mc).start(); 无法使用

        // 创建线程池，提交任务
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(mc);

        // 获得结果
        Future<Integer> future = pool.submit(mc);
        Integer result = future.get();

        // 输出结果
        System.out.println(result);

        // 关闭线程池
        pool.shutdown();
    }
}
