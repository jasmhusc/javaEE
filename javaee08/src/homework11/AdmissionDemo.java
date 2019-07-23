package homework11;

/**
 * 某公司组织年会，会议入场时有两个入口，在入场时每位员工都能获取一张双色球彩票，假设公司有100个员工，
 * 利用多线程模拟年会入场过程，并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。
 */
public class AdmissionDemo {
    public static void main(String[] args) {

        // 创建多条线程
        Admission ad = new Admission();
        Thread t1 = new Thread(ad, "前门");
        Thread t2 = new Thread(ad, "后门");

        // 开启线程
        t1.start();
        t2.start();
    }
}
