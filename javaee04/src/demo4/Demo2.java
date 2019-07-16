package demo4;

public class Demo2 {
    public static void main(String[] args) {

        // currentTimeMillis() 当前时间毫秒值
        long time = System.currentTimeMillis();
        System.out.println(time);

//        获取某个算法的计算时间
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("计算时间为：" + (end - start));
    }
}
