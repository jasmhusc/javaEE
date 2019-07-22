package demo10;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    // 2.定义类实现Callable
    @Override
    public Object call() throws Exception {
        // 3.重写call方法
        return "Callable执行完毕";
    }
}
