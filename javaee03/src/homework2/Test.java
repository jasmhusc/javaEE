package homework2;

public class Test {
    public static void main(String[] args) {
        Company huawei = new Company("华为", 10000);
        huawei.showAccount();
        huawei.pay(new Manager("任正非", 3000));
        huawei.pay(new Manager("余承东", 1000));
        huawei.pay(new Coder("胡歌", 500));
    }
}
