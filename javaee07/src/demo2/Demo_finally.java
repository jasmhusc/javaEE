package demo2;

public class Demo_finally {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        try {
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.err.println("除数不能为0");  // 错误信息，显示红色
            return;
        } finally {
            System.out.println("finally1");
            System.out.println("finally2");
            System.out.println("最后一口气");
        }

        System.out.println("最后语句");
    }
}
