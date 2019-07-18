package homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < 5; i++) {
            while (set.size() < 6) {
                set.add(new Random().nextInt(33) + 1);
            }
            while (set.size() < 7) {
                set.add(new Random().nextInt(16) + 1);
            }
            for (Integer num : set) {
                System.out.printf("%02d", num);
                System.out.print(" ");
            }
            System.out.println();
            set.clear();
        }
    }
}
