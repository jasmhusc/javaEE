package demo5;

public class IntegerDemo {
    /**
     * @param args int   Integer 包装类
     *             1.包装类含有许多方法
     *             2.其他包装类与此类似
     */
    public static void main(String[] args) {

        // 字符串转换为数字: String --> int
        String s = 5 + "";
        int i = Integer.parseInt(s);

        // String --> double
        String s2 = 5.34 + "";
        double v = Double.parseDouble(s2);

    }
}
