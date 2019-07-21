package homework;

public class Lamda {
    public static void main(String[] args) {
        // 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("大家好！");
            }
        }).start();

        // Lambda表达式
        new Thread(() -> System.out.println("大家好！")).start();

        // run方法   相当于只是调用普通方法
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("大家好,我也好！");
            }
        };
        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("大家好,我也好！");
            }
        };

        run1.run();
        run2.run();
    }
}
