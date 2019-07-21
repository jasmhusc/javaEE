package demo6;

/*
    1. 并行：指两个或多个事件在同一时刻发生（同时发生）。
       并发：指两个或多个事件在同一个时间段内发生

    2. Java 程序的进程里面至少包含两个线程:
        主进程也就是 main()方法线程，另外一个是垃圾回收机制线程。

    3. 进程：有独立的内存空间，进程中的数据存放空间（堆空间和栈空间）是独立的，至少有一个线程。
        线程：堆空间是共享的，栈空间是独立的，线程消耗的资源比进程小的多。
 */
public class Demo6 {
    public static void main(String[] args) {
        //创建自定义线程对象
        MyThread mt = new MyThread("新的线程");

        //开启新线程
        mt.start();

        //在主方法中执行for循环
        for (int i = 0; i < 200; i++) {
            System.out.println("main线程！" + i);
        }
    }
}
