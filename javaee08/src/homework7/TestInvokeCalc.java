package homework7;

public class TestInvokeCalc {
    public static void main(String[] args) {
        //  请分别使用Lambda调用invokeCalc方法来计算130‐120的结果
        invokeCalc(130, 120, (a, b) -> a - b);
    }

    public static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }
}
