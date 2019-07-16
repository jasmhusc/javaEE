package demo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseDate {
    public static void main(String[] args) throws ParseException {
        /*
         * 解析文本，返回Date对象
         * */
        String s = "2017-11-23 07:38:30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(s);
        System.out.println(date);
    }
}
