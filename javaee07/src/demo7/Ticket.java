package demo7;

public class Ticket implements Runnable {
    // 总票数100张
    private int polls = 100;

    /*
     * 执行卖票操作
     * */
    @Override
    public void run() {
        //每个窗口卖票的操作
        while (polls > 0) {
            //出票操作
            try {
                //使用sleep模拟一下出票时间
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //获取当前线程对象的名字
            String name = Thread.currentThread().getName();
            System.out.println(name + "在卖第" + (polls--) + "张票");
        }
    }
}
