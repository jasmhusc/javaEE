package homework1;

public class Test {
    public static void main(String[] args) {
        // split的参数是正则表达式
        String s = "dd.tct";
        String[] split = s.split("[.]");
        System.out.println(split.length);
        for (String s1 : split) {
            System.out.println(s1);
        }
    }
}
