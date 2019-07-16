package demo1;

import java.util.Date;

/*
 * CST: china standard time
 * 东八时区：Tue Jul 16 09:22:54 CST 2019
 * */
public class Demo1 {
    public static void main(String[] args) {
//            创建当前时间
        Date now = new Date();
        System.out.println(now);

//        传入参数：毫秒值
//        Thu Jan 01 08:00:02 CST 1970
        Date date = new Date(2000);
        System.out.println(date);

//        返回当前Date对象到1970之间的毫秒值
        long time = now.getTime();
        System.out.println(time);

//        设置时间，同有参构造函数
        now.setTime(3000);
        System.out.println(now);
    }
}
