package demo9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class seekPhone {

    public static void main(String[] args) {

        String s = "我爸爸的手机号是13409749600，我的手机号是15927162908，我另一个的手机号是18062136736！";
        String regex = "1[35789]\\d{9}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find())
            System.out.println(m.group());

        //System.out.println(Pattern.compile(regex).matcher(s).find());

    }

}
