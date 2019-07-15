package demo08;

import java.util.Arrays;

/**
 * a,b,c三个数之和为1000, a^2 + b^2 = c^2, 求 a, b, c.
 */
public class Test {
    public static void main(String[] args) {

//        method1();
        sortMerge(new int[]{9, 1, 2, 11, 8, 3, 2, 7, 12, 3, 6, 9, 4, 5, 0});
    }

    private static void method1() {
        /*
         * 算法复杂度为：O(n^2)
         * */
        for (int i = 1; i < 500; i++) {
            for (int j = 500 - i; j < 500; j++) {
                int c = 1000 - i - j;
                if (i * i + j * j == c * c)
                    System.out.println(i + " " + j + " " + c);
            }
        }
    }

    /**
     * 调用递归，以空间换时间，算法复杂度为 O(nlogn)
     */
    private static void sortMerge(int[] arr) {

        if (arr == null)
            throw new NullPointerException("Array can not be null!");
        int len = arr.length;
        if (len > 1) {
            int mid = (int) Math.floor(len / 2);
            int[] partitionA = Arrays.copyOfRange(arr, 0, mid);
            int[] partitionB = Arrays.copyOfRange(arr, mid, len);
            sortMerge(partitionA);
            sortMerge(partitionB);
            sort(arr, partitionA, partitionB);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int[] partitionA, int[] partitionB) {
        int i = 0;
        int j = 0;
        int k = 0;

        if (partitionA.length == 1 && partitionB.length == 1) {
            if (partitionA[0] > partitionB[0]) {
                arr[0] = partitionB[0];
                arr[1] = partitionA[0];
            }
        }
        while (true) {
            if (partitionA[i] <= partitionB[j]) {
                arr[k++] = partitionA[i++];
            } else {
                arr[k++] = partitionB[j++];
            }
            if (i == partitionA.length) {
                while (j < partitionB.length) {
                    arr[k++] = partitionB[j++];
                }
                break;
            }
            if (j == partitionB.length) {
                while (i < partitionA.length) {
                    arr[k++] = partitionA[i++];
                }
                break;
            }
        }
    }
}
