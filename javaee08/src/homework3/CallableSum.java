package homework3;

import java.util.concurrent.*;

public class CallableSum {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建callable任务
        Callable c = new Sum();

        //创建线程池执行Callable任务
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<Integer> future1 = pool.submit(c);
        Integer result1 = future1.get();

        Future<Integer> future2 = pool.submit(c);
        Integer result2 = future2.get();

        Future<Integer> future3 = pool.submit(c);
        Integer result3 = future3.get();

        pool.shutdown();
        // 3个结果平均值
        System.out.println("平均值1：" + result1);
        System.out.println("平均值2：" + result2);
        System.out.println("平均值3：" + result3);
        System.out.println("最终平均值：" + (result1 + result2 + result3) / 3);
    }
}
