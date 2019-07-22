package demo9;

import java.util.LinkedList;
import java.util.Random;

public class Producer extends Thread {
    private Book[] store;
    private LinkedList<Book> list;

    public Producer(LinkedList<Book> list, String name) {
        super(name);
        this.list = list;
        store = new Book[]{new Book("雪山飞狐", 13.6), new Book("JAVA高级教程", 38.8), new Book("红楼梦", 26.9)};
    }

    @Override
    public void run() {
        // 状态一直持续，死循环
        while (true) {
            synchronized (list) {
                if (list.size() > 1) try {
                    list.wait();
                } catch (Exception e) {
                }
                // 如果list没有书，就从已有的书店随机拿一本书
                Book book = getEleOfArray(store);
                list.add(book);
                System.out.println(getName() + "生产一本" + book);

                // 随机唤醒一条线程，这里只有一条线程等待，必定是唤醒对方，等同于==notifyAll
                list.notify();
            }
        }
    }

    // 随机从数组中取出一个元素的函数
    private static <T> T getEleOfArray(T[] t) {
        T ret = null;
        int len = t.length;
        if (len > 0) {
            int i = new Random().nextInt(len);
            ret = t[i];
        }
        return ret;
    }
}
