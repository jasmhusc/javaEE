package demo8;

public class DemoDieLock {
    public static void main(String[] args) {

        // 创建线程任务
        DieLock dl = new DieLock();

        // 开启线程
        new Thread(dl).start();
        new Thread(dl).start();
    }
}
