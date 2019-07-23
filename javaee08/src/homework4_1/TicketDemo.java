package homework4_1;

/**
 * @author 写一个卖票的程序，
 * 1. 写一个类，该类继承Thread，定义一个变量记录总票数。
 * 2. 开启四个卖票窗口(开始四个线程),同时执行卖票的程序。
 * 要求:
 * 1.每卖一张票在控制台输出：当前窗口为：窗口a卖了一张票，剩余票数为19。其中窗口a为线程的名字。
 * 2.统计每个窗口个卖了多少张票。
 */
public class TicketDemo {
    public static void main(String[] args) {
        // 创建总的票数
        int n = 100;

        // 创建4条线程
        new TicketThread("窗口A", n).start();
        new TicketThread("窗口B", n).start();
        new TicketThread("窗口C", n).start();
        new TicketThread("窗口D", n).start();
    }
}
