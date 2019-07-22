package demo3;

public class MyCinema implements Runnable {

    // 无需再用static修饰，因为只创建了一个MyCinema对象
    private int poll = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public synchronized void show() {
        // 同步方法锁对象为This
        if (poll > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + poll--);

        }
    }
/*	public void run() {
		while(true) {
			synchronized (obj) {
		// 静态方法锁对象为	MyCinema.class
		//  synchronized (This){  等同于   同步方法
		//  synchronized (MyCinema.class){  等同于   静态同步方法
			if(poll>0) {
				try {

					Thread.sleep(100);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" "+poll--);

			}
			else
				break;}
	}
	} */
}
