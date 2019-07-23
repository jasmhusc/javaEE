package homework4;

import java.util.concurrent.ExecutionException;

public class TestMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // main方法也可以调用，但是要处理其中的异常
        String[] myargs = {"aa", "bb"};
        DemoFactorial.main(myargs);
    }
}
