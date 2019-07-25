package homework2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        byte[] arr = "Love我".getBytes();
        System.out.println(Arrays.toString(arr));
        // forEach增强for循环不行
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^= 8;
        }
        System.out.println(Arrays.toString(arr));
    }
}
