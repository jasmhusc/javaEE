package demo10;

public class MYRunnable implements Runnable {
    // 2.定义类实现Runnable接口
    // 3.重写run方法.(任务)
    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println(Thread.currentThread() + ":    " + i);
        }
    }
}
