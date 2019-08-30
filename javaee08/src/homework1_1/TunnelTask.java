package homework1_1;

public class TunnelTask implements Runnable {
    int n;
    public TunnelTask(int n){
        this.n = n;
    }
    @Override
    public void run() {
            getThrough();
    }
    // 同步方法
    private synchronized void getThrough(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
