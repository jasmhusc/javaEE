package demo4;

import java.util.Arrays;

/**
 * 冒泡排序2：
 * 每轮比较的是第i个元素与其后面每个元素j的大小
 * ，而不是比较相邻的元素。
 */
public class Demo_bubble2 {
    public static void main(String[] args) {
        double[] d = new double[]{2.4, 5.3, 3.6, 1.4, 4.3};
//      外层控制轮数sdcc
        for (int i = 0; i < d.length - 1; i++) {
//          相邻位置上的元素大小，大的往后排
            for (int j = i + 1; j < d.length; j++) {

                if (d[i] > d[j]) {
                    double temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(d));
    }
}
