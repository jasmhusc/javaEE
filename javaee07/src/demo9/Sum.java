package demo9;

/**
 * 10此循环结果出现10，11次整数
 * 求和输出2次
 * 线程不安全
 */
public class Sum {
    public static void main(String[] args) {
        // 创建一个线程任务，随机产生10个100~1000间的整数，并求和
        MyRunnable mr = new MyRunnable();

        // 创建2个线程执行求和
        new Thread(mr, "线程1").start();
        new Thread(mr, "线程2").start();
    }
}
