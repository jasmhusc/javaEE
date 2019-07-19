package demo1;

/*
 * 可变参数
 *   1. 参数类型相同，参数个数任意
 *   2. 底层是数组
 * 注意事项：
 *   1. 修饰符 返回值类型 方法名(参数类型... 参数名){}
 *   2. 可变参数要放在参数列表最后面，一个方法只能有一个可变参数。
 * */
public class Demo_VarParameter {

    public static void main(String[] args) {

        System.out.println(sum());
    }

    private static int sum(int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
