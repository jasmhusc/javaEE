package demo5;

public class MyJoinDemo {
    public static void main(String[] args) {

        MyJoin m1 = new MyJoin("范乔丹");
        MyJoin m2 = new MyJoin("鲍科比");
        MyJoin m3 = new MyJoin("卡哇伊");

        m1.start();
        //插入 join方法
        // m1 执行完才会执行后面的线程，在其前面的线程则继续与其同时执行
        //需要抛出异常
        try {
            m2.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        m3.start();
    }
}

class MyJoin extends Thread {

    public MyJoin() {
    }

    public MyJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {

            System.out.println(getName() + "  " + i);
        }
    }
}
