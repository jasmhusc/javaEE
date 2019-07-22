package demo11;

import java.util.concurrent.Callable;

/*
    自从Java 1.5开始，就提供了Callable和Future，通过它们可以在任务执行完毕之后得到任务执行结果。
    这是一个泛型接口，call()函数返回的类型就是传递进来的V类型---Callable<V>
 */
public class MyCallable implements Callable<Integer> {
    // 计算的1~n的和
    int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
