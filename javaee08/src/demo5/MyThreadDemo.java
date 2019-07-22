package demo5;

public class MyThreadDemo {
    public static void main(String[] args) {

        // 创建多线程对象
        // my.run(); 直接调用run()方法相当于普通方法，是单线程
        // start()首先启动线程，然后有Jvm调用run()方法
        // run()方法仅仅是对线程执行的代码进行封装，直接用就是普通方法
        // java只能单继承，不太方便

        // 通过setName()方法或构造函数传入线程名称
        MyThread2 m1 = new MyThread2();
        MyThread2 m2 = new MyThread2("线程2");

        m1.setName("线程1");

        // 设置线程优先级 (1--10， 默认5)
        m1.setPriority(2);
        m2.setPriority(6);

        //启动线程
        m1.start();
        m2.start();

        // 设置和返回当前正在执行的线程对象的名称
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread2 extends Thread {

    // 有参构造和无参构造同时设置
    public MyThread2() {
    }

    public MyThread2(String name) {
        super(name);
    }

    // 自定义类继承Thread类，重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " " + i);
        }
    }
}
