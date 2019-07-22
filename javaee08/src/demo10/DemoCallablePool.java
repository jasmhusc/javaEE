package demo10;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*Callable和Runnable类似
        Callable接口介绍:
public interface Callable<V> {
    V call() throws Exception;
}

    Callable方式好处:
            1.方法可以抛异常
            2.方法有返回值*/
public class DemoCallablePool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 4.创建实现类对象
        MyCallable mc = new MyCallable();

        // 5.提交任务
        pool.submit(mc);
        pool.submit(mc);

        // 6.得到返回的结果
        Future<String> future = pool.submit(mc);
        // Object o = future.get(); Future<?> 需要给定泛型，此处要抛出异常
        String result = future.get();
        System.out.println(result);
        /*
         * submit提交任务,由线程调用call方法,call方法的返回值放到Future对象中*/

        // 7.关闭线程池（工作不需要）
        pool.shutdown();
    }
}
