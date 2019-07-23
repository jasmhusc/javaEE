package homework2_1;

/**
 * Thread 创建多线程，共享数据为基本类型时，必须是static;
 * 引用类型可以是static, 也可以通过构造函数传地址。
 */
public class CupThread extends Thread {
    // 杯子数为100, 且必须为static
    private static int cups = 100;

    public CupThread() {
    }

    public CupThread(String name) {
        super(name);
    }

    // 重写run方法
    @Override
    public void run() {
        int num = 0;
        while (true) {
            // 同步代码块
            synchronized (CupThread.class) {
                if (cups > 0) {
                    cups--;
                    num++;
                    System.out.println(getName() + "卖出第" + (100 - cups) + "个，总共剩余" + cups + "个..");
                    Thread.yield();
                } else {
                    System.out.println(getName() + "卖了" + num + "个");
                    break;
                }
            }
        }
    }
}
