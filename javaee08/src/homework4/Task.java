package homework4;

public class Task implements Runnable {
    int n;

    public Task(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println(n + "!     " + getFactorial(n));
    }

    // 求阶乘的函数
    private static int getFactorial(int n) {
        if (n == 1)
            return 1;
        return n * getFactorial(n - 1);
    }
}
