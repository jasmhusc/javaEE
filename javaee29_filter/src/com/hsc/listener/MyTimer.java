package com.hsc.listener;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
    public static void main(String[] args) {

        // 设置定时任务
        //2.订制定时任务计划
        /**
         * 方式1：timer.schedule(TimerTask,long,long);
         *      参数1：TimerTask，任务接口，编写任务代码
         *      参数2：long，设置距离第一次执行的毫秒数
         *      参数3：long，每一次执行的间隔毫秒数
         * 方式2：timer.schedule(TimerTask,Date,long);
         *      参数1：TimerTask，任务接口，编写任务代码
         *      参数2：Date，设置第一次执行的时间
         *      参数3：long，每一次执行的间隔毫秒数
         */
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("aa");
            }
        }, 1, 1000);
    }
}
