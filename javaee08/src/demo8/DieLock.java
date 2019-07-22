package demo8;

public class DieLock implements Runnable {
    private Object objA = new Object();
    private Object objB = new Object();

    @Override
    public void run() {
        // 死锁
        synchronized (objA) {
            System.out.println("1--objA");
            synchronized (objB) {
                System.out.println("1--objB");
            }
        }
        synchronized (objB) {
            System.out.println("2--objB");
            synchronized (objA) {
                System.out.println("2--objA");
            }
        }
    }
}
