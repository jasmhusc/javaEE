package homework11;

public class Admission implements Runnable {
    // 员工人数100
    int count = 100;

    @Override
    public void run() {
        // 计数两个门通过的人
        int num = 0;
        //获取线程的名字
        String name = null;
        // 条件判断在里，同步锁在外面
        while (true) {
//        while (count > 0) {    // no
            synchronized (this) {
                if (count > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    name = Thread.currentThread().getName();
                    System.out.println("编号为: " + count + " 的员工 从" + name + " 入场! 拿到的双色球彩票号码是:" + DoubleColorBallUtil.create());
                    count--;
                    num++;
                    Thread.yield();
                } else {
                    System.out.println("从" + name + "入场的员工总共: " + num + " 位员工");
                    break;
                }
            }
        }
    }
}
