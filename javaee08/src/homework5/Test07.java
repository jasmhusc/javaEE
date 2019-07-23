package homework5;

public class Test07 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
    // 可以正常输出1~9 下面的run方法相当于重载，不会调用

    public static void main(String[] args) {
        Thread t = new Thread(new Test07());
        t.start();
    }

    public void run(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(i);
        }
    }
}
