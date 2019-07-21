package demo1;

public class Demo_throw {
    public static void main(String[] args) {
        // 定义数组
        Double[] drr = new Double[]{1.2, 6.3, 4.5, 8.4, 5.6, 3.9};

        // 定义方法并调用，获得指定位置的元素
        Double d1 = getElement(drr, 3);  // 8.4
        System.out.println(d1);

        // 越界时的情况
        System.out.println(getElement(drr, 6));   //抛出异常
    }

    //  定义一个方法，接收任意类型数组和索引，返回该索引处的值，越界就抛出异常。
    private static <E> E getElement(E[] ts, int i) {
        if (i < 0 || i > ts.length - 1)
            throw new IndexOutOfBoundsException("索引越界啦！");
        return ts[i];
    }
}
