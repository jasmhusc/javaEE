package homework1_1;

/**
 * @author 1. 请按要求编写多线程应用程序，模拟多个人通过一个山洞：
 * 1.1 这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒。
 * 1.2 随机生成10个人，同时准备过此山洞，显示每次通过山洞人的姓名。
 */
public class Tunnel {
    public static void main(String[] args) {
        int n = 10;
        TunnelTask task = new TunnelTask(n);
        for (int i = 0; i < n; i++) {
            // 随机生成10个人
            new Thread(task, "Person" + i).start();
        }
    }
}
