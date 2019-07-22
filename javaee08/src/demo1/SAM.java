package demo1;

/* Single Abstract Method Interface
 *    1. 函数式接口完全是为实现 Lambda 表达式而定义的；
 *    2. Lambda 表达式的目标类型就是函数式接口；
 *    3. 凡是出现函数式接口的地方，都可以将一个Lambda表达式作为它的实现；
 *    4. static 和 default 函数不影响一个接口成为函数式接口。
 *    5. 标记：@FunctionalInterface
 */
public class SAM {
    public static void main(String[] args) {
        /*
         * Call c = x -> System.out.println(x)
         * */
        Call c = System.out::println;
        c.apply(8);
    }
}

@FunctionalInterface
interface Call {
    // abstract
    void apply(int i);

    // static
    static void fun1() {
        System.out.println("static");
    }

    // default
    default void fun2() {
        System.out.println("default");
    }
}