package homework1;

import java.util.Calendar;
import java.util.Date;

public class Test5 {
    public static void main(String[] args) {

        // Calendar
        Calendar cal = Calendar.getInstance();
        // 获取日期 Date 对象
        Date date = cal.getTime();
        System.out.println("date = " + date);
        // 输出年月日
        getDate(cal);
        // 获取500天后的日期
        cal.add(Calendar.DAY_OF_MONTH, 500);
        Date date1 = cal.getTime();
        getDate(cal);
    }

    private static void getDate(Calendar cal) {
        // 获取年月日
        int year = cal.get(Calendar.YEAR);
        int mon = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "/" + (mon + 1) + "/" + day);
    }
}
