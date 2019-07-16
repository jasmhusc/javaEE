package demo2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo2 {

    public static void main(String[] args) {
        /*将日期转换为字符串
         * */
        // 创建当前 Date对象
        Date date = new Date();
        // 创建sdf对象，使用默认格式
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println(sdf.format(date));
        /*
         * 指定格式：
         *   yyyy年MM月dd日 HH时mm分ss秒
         * */
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒").format(date));
    }
}
