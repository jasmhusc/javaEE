package demo7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo4_Callable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new MyCallable(10));
        // 有返回值，是 Future类型 异步计算的结果，检查计算是否完成

        Future<Integer> f = pool.submit(new MyCallable(100));
        System.out.println(f.get());

        pool.shutdown();
    }

}

class MyCallable implements Callable<Integer> {

    private int num;

    public MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

}