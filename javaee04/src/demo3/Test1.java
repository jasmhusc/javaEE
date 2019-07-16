package demo3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {

    public static void main(String[] args) throws ParseException {
        String birthday = "1983年8月23日";
        String today = "2019年5月22日";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

        Date d1 = sdf.parse(birthday);
        Date d2 = sdf.parse(today);

        long time = d2.getTime() - d1.getTime();
        System.out.println(time / 1000 / 60 / 60 / 24 / 365 + "天");

    }

}
