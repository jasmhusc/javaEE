package homework4_1;

public class TicketThread extends Thread {
    private static int poll;

    public TicketThread() {
    }

    public TicketThread(String name, int poll) {
        super(name);
        this.poll = poll;
    }

    @Override
    public void run() {
        // 记录每一个窗口卖出的票数
        int num = 0;
        // while(true)+break条件控制
        while (true) {
            synchronized (TicketThread.class) {
                if (poll > 0) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        System.out.println("模拟卖票时间，无其他含义。");
                    }
                    poll--;
                    num++;
                    System.out.println("当前窗口为：" + getName() + "卖了一张票，剩余票数为" + poll + "。");
                } else {
                    System.out.println(getName() + "共计卖出" + num);
                    break;
                }
            }
        }
    }
}
