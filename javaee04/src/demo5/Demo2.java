package demo5;

public class Demo2 {
    public static void main(String[] args) {

        // int --> Integer
//        Integer i = new Integer(5);  过时

        // valueof 装箱
        int i = 8;
        Integer i2 = Integer.valueOf(i);

        // 拆箱  Integer --> int
        Integer i3 = 7;
        int i4 = i3.intValue();

        /**
         * 自动装箱: 原理是用 Integer.valueOf()
         * 自动拆箱： 原理是用 Integer.intValue()
         */
        Integer a = 4;
        int aa = a;

        // Integer的最值，上下界限
        System.out.println("最大值：" + Integer.MAX_VALUE);
        System.out.println("最小值：" + Integer.MIN_VALUE);
    }
}
