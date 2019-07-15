package homework2;

public class Company implements Account {
    private String companyName;
    private double account;

    public Company() {
    }

    public Company(String companyName, double account) {
        this.companyName = companyName;
        this.account = account;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    @Override
    public void pay(Employee e) {
        double salary = e.getSalary();
        account -= salary;
        System.out.println(companyName + "公司给" + e.getName() + "发放工资" + salary);
        showAccount();
    }

    @Override
    public void showAccount() {
        System.out.println("账户余额：" + account);
    }
}
