package demo6;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo2_Timer {
// 计时器类，在指定时间完成指定任务

    public static void main(String[] args) throws InterruptedException {

        Timer t = new Timer();
        //3秒重复
        t.schedule(new MyTimerTask(), new Date(119, 5, 2, 10, 47, 30), 3000);

        while (true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }

}

class MyTimerTask extends TimerTask {

    @Override
    public void run() {

        System.out.println("起床学习Java！");
    }


}