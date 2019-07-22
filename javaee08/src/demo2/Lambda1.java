package demo2;

/*
    定义接口Sum，Lambda表达式求和。
    1. 小括号内参数的类型可以省略；
    2. 如果小括号内有且仅有一个参，则小括号可以省略；
    3. 如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。
 */
public class Lambda1 {
    public static void main(String[] args) {
        // 用int类型接收返回值
        Sum s = (x, y) -> x + y;
        int sum = s.add(2, 5);
        System.out.println(sum);
    }
}

@FunctionalInterface
interface Sum {
    // 求和
    int add(int n1, int n2);
}