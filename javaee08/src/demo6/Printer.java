package demo6;

/*
 *   1.等待唤醒机制 同步代码块中，用哪个对象锁，就用哪个对象调用 wait()方法
 *   2.因为锁对象可以是任意的，所以 wait()和notify()定义在Object类中
 *   3. sleep和wait的区别：
 *    3.1 Sleep方法必须传入时间参数，时间到自动醒来；
 *        Wait方法可以传参数也可以不传，不传直接等待，传参数一定时间后等待
 *    3.2 Sleep方法不会释放锁，而wait会释放锁；
 *    ReenTrantLock r = new ReenTrantLock();
 *    r.lock    r.unlock
 */
public class Printer {
    private int flag = 1;

    public void printer1() throws InterruptedException {
        synchronized (this) {
            if (flag != 1)
                this.wait();
            System.out.print("东");
            System.out.print("方");
            System.out.print("不");
            System.out.print("败");
            System.out.print("\r\n");
            flag = 2;
            this.notify();
        }
    }

    public void printer2() throws InterruptedException {
        synchronized (this) {
            if (flag != 2)
                this.wait();
            System.out.print("西");
            System.out.print("游");
            System.out.print("记");
            System.out.print("后");
            System.out.print("传");
            System.out.print("\r\n");
            flag = 1;
            this.notify();
        }
    }
}
