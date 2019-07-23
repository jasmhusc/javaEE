package homework3_1;

/**
 * 3. 有一辆班车除司机外只能承载80个人，假设前中后三个车门都能上车，如果坐满则不能再上车。请用线程模拟
 * 3.1 上车过程并且在控制台打印出是从哪个车门上车以及剩下的座位数。
 * 3.2 比如:（前门上车---还剩N个座...）
 */
public class CarDemo {
    public static void main(String[] args) {

        // 前中后3个门
        new CarThread("前").start();
        new CarThread("后").start();
        new CarThread("中").start();
    }
}
