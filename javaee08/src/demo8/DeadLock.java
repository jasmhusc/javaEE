package demo8;

public class DeadLock {
    public static void main(String[] args) {

        new Thread(() -> {
            synchronized ("A") {
                System.out.println("筷子");
                synchronized ("B") {
                    System.out.println("筷子");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized ("B") {
                System.out.println("刀");
                synchronized ("A") {
                    System.out.println("叉");
                }
            }
        }).start();
    }
}
