package homework2_1;

/**
 * @author 2. 有100个限量版的水杯，但是只能通过实体店和官网才能进行购买，并且分别统计卖了多少。请用线程进行模拟
 * 2.1 并设置线程名称用来代表售出途径，再将信息打印出来。
 * 2.2 比如（实体店卖出第1个，总共剩余n个..）
 */
public class CupDemo {
    public static void main(String[] args) {
        // 开启线程
        new CupThread("实体店").start();
        new CupThread("网上商城").start();
    }
}
