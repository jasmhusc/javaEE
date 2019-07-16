package demo3;

import java.util.Calendar;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = sc.nextInt();
        boolean b = getYear(year);
        if (b)
            System.out.println(year + "是闰年");
        else
            System.out.println(year + "是平年");

    }

    public static boolean getYear(int year) {

        Calendar c = Calendar.getInstance();   // 父类 c 引用指向子类对象
        c.set(year, 2, 1);        // 设置为3月1日
        c.add(Calendar.DAY_OF_MONTH, -1);   // 后退1天
        return c.get(Calendar.DAY_OF_MONTH) == 29;   // 看看这天是否为2月29日
    }

}
