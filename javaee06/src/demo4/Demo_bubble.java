package demo4;

import java.util.Arrays;

/**
 * 冒泡排序：
 * 双重循环嵌套
 * 外层控制轮数，内层控制每轮调换顺序的两个元素
 * 每轮比较的是相邻位置上的元素大小，大的往后排
 */
public class Demo_bubble {
    public static void main(String[] args) {

        double[] d = new double[]{2.4, 5.3, 3.6, 1.4, 4.3};
//      外层控制轮数sdcc
        for (int i = 0; i < d.length - 1; i++) {
//          相邻位置上的元素大小，大的往后排
            for (int j = 0; j < d.length - 1 - i; j++) {

                if (d[j] > d[j + 1]) {
                    double temp = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(d));
    }
}
