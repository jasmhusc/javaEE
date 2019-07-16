package homework1;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Test6 {
    public static void main(String[] args) {

        String[] s = {"a", "ab", "aaa", "bb", "ccc"};
        swap(s, 1, 3);
        System.out.println(Arrays.toString(s));
    }

    private static <T> T[] swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    private static <E> LinkedList<E> sort(LinkedList<E> list) {
        Collections.shuffle(list);
        return list;
    }
}
