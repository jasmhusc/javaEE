package demo3;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {

        // 获取Calendar对象
        Calendar cal = Calendar.getInstance();

        //获取字段：year,month,day....
        int year = cal.get(Calendar.YEAR);
        System.out.println("year = " + year);
        int m = cal.get(Calendar.MONTH);
        System.out.println("m = " + m);
        int d = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println("d = " + d);
        int s = cal.get(Calendar.SECOND);
        System.out.println("s = " + s);

        // 将给定的日历字段设置为指定的值
        cal.set(Calendar.YEAR, 2088);
        cal.set(Calendar.DAY_OF_MONTH, 23);
        System.out.println("修改后的日期：" + cal.get(Calendar.YEAR) + ":" + cal.get(Calendar.MONTH) + ":" + cal.get(Calendar.DAY_OF_MONTH));

        // 在Calendar表示的时间上增加或减少指定的时间
        cal.add(Calendar.YEAR, -93);
        cal.add(Calendar.MONTH, 2);
        System.out.println("修改后的日期：" + cal.get(Calendar.YEAR) + ":" + cal.get(Calendar.MONTH) + ":" + cal.get(Calendar.DAY_OF_MONTH));
    }
}
