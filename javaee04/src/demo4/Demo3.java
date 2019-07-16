package demo4;

import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        /*
         * 数组复制
         * arraycopy(原数组,起始索引,新数组,起始索引,复制元素个数)
         * */
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[8];

        System.arraycopy(arr1, 1, arr2, 3, 3);
        System.out.println(Arrays.toString(arr2));
    }
}
