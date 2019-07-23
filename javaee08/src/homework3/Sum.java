package homework3;

import java.util.Random;
import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {
    int sum = 0;

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            int r = new Random().nextInt(100) + 1;
            System.out.println(r);
            sum += r;
        }
        return sum / 10;
    }
}
