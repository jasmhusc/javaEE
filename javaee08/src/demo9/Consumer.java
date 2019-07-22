package demo9;

import java.util.LinkedList;

public class Consumer extends Thread {
    private LinkedList<Book> list;

    public Consumer(LinkedList<Book> list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() == 0) try {
                    list.wait();
                } catch (InterruptedException e) {
                }
                // 如果list有书，就购买第一本
                Book book = list.remove(0);
                System.out.println(getName() + "购买一本" + book);
                // 唤醒另一条线程
                list.notify();
            }
        }
    }
}
