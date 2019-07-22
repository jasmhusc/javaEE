package demo3;

public class ThreadCase {
    private static int num = 0;

    public static void main(String[] args) {
        // 在不同条件下，分别开启两条线程，查看结果

        for (int i = 1; i < 11; i++) {

            // 单数+1，偶数-1
            if (i % 2 == 0) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        num++;
                        System.out.println(Thread.currentThread().getName() + ":      " + num);
                    }
                }, "线程" + i).start();
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        num--;
                        System.out.println(Thread.currentThread().getName() + ":      " + num);
                    }
                }, "线程" + i).start();
            }
        }
//        System.out.println(num);   上面线程没有执行完，num就输出了，肯定有问题。
        try {
            // 让上面10条线程跑完，在输出num，结果一定是0
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
