package demo6;

/**
 * 实现Runnable接口比继承Thread类所具有的优势：
 * 1. 适合多个相同的程序代码的线程去共享同一个资源。
 * 2. 可以避免java中的单继承的局限性。
 * 3. 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
 * 4. 线程池只能放入实现Runable或Callable类线程，不能直接放入继承Thread的类。
 */
public class Demo6_1 {
    public static void main(String[] args) {

        //创建自定义类对象 线程任务对象
        MyRunnable mr = new MyRunnable();

        //创建线程
        Thread t1 = new Thread(mr, "旺财");
        Thread t2 = new Thread(mr, "小强");

        // 开启线程
        t1.start();
        t2.start();
    }
}