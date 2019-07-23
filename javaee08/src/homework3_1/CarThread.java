package homework3_1;

public class CarThread extends Thread {
    // 用引用类型保存共享数据
    static int seats = 80;
    int num = 0;

    public CarThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
//            synchronized (this) {  no
            synchronized (CarThread.class) {  // ok
                if (seats > 0) {
                    try {
                        // 模拟上车时间
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seats--;
                    num++;
                    System.out.println(getName() + "上车---还剩" + seats + "个座...");
                    // 礼让
                    Thread.yield();
                } else {
                    System.out.println(getName() + ":     " + num);
                    break;
                }
            }
        }
    }
}
