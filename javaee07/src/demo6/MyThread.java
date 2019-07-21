package demo6;

public class MyThread extends Thread {
    //定义指定线程名称的构造方法
    public MyThread() {
        super();
    }

    public MyThread(String s) {
        //调用父类的String参数的构造方法，指定线程的名称
        super(s);
    }

    /**
     * 重写run方法，完成该线程执行的逻辑
     */
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {

            System.out.println(Thread.currentThread().getName() + "： " + i);
        }
    }
}
