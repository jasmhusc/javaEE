package homework5_1;

import java.util.concurrent.Callable;

public class FactorialCallable implements Callable<Integer> {
    // 定义一个变量用于存储阶乘参数
    private int fac;

    // 构造函数用于传递参数fac和线程名字name
    public FactorialCallable(int fac) {
        this.fac = fac;
    }

    @Override
    public Integer call() throws Exception {
        // 返回计算的阶乘结果
        return factorial(fac);
    }

    // 创建计算阶乘的函数factorial()
    public int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}
