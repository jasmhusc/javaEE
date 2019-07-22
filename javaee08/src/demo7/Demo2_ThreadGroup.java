package demo7;

public class Demo2_ThreadGroup {

    public static void main(String[] args) {
        //Demo1();
        MyRunnable mr = new MyRunnable();              // 创建Runnable子类对象
        ThreadGroup tg = new ThreadGroup("pool");     // 创建线程组
        Thread t1 = new Thread(tg, mr, "James");     // 将线程放入线程组
        Thread t2 = new Thread(tg, mr, "Paul");
        // 打印线程组名称：
        System.out.println(t1.getThreadGroup().getName() + "\r\n" + t2.getThreadGroup().getName());

        // 好处是可以对整个线程组进行设置(如守护线程)
        tg.setDaemon(true);

    }

    private static void Demo1() {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr, "James");
        Thread t2 = new Thread(mr, "Paul");
        // 获取线程所在的线程组
        ThreadGroup tg1 = t1.getThreadGroup();
        ThreadGroup tg2 = t2.getThreadGroup();
        // 打印默认的线程组名称：main
        System.out.println(tg1.getName() + "\r\n" + tg2.getName());
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(Thread.currentThread().getName() + "...." + i);

    }


}