package demo6;

public class Demo3_Notify {

    public static void main(String[] args) {
        final Printer p = new Printer();

        new Thread("线程1：") {
            public void run() {
                // run方法的异常只能处理
                while (true) {
                    try {
                        p.printer1();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread("线程2：") {
            public void run() {
                while (true) {
                    try {
                        p.printer2();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

}
