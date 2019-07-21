package demo6;

/**
 * 匿名内部类方式创建线程
 */
public class NoNameInnerClassThread {
    public static void main(String[] args) {

        // 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }, "武松").start();


        // 主线程
        for (int i = 0; i < 100; i++) {
            System.out.println("林冲： " + i);
        }
    }
}
