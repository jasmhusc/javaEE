package demo9;

import java.util.LinkedList;

// 测试书店生产者和消费者的多线程程序
public class TestBook {
    public static void main(String[] args) {

        Object obj = new Object();
        // obj.wait(); // IllegalMonitorStateException: 非法监视状态异常，主线程不能weit()

        // 创建锁对象
        LinkedList<Book> list = new LinkedList<>();
        // 创建多线程程序
        new Producer(list, "书店").start();
        new Consumer(list, "🐖").start();
    }
}
