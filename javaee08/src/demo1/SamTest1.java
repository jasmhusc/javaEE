package demo1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * java8编程主要的4类函数式接口：
 *    1. Predicate   test     判断函数，有输入，有返回，返回 true or false;
 *    2. Function    apply    有输入，也有返回;
 *    3. Consumer    accept   传入参数，无返回值，只进不出;
 *    4. Supplier    无参数    不需传参，有返回值，只出不进;
 */
public class SamTest1 {
    public static void main(String[] args) {

        // Predicate (传入类型)
        Predicate<String> p = "yes"::equalsIgnoreCase; //"yes".equalsIgnoreCase(e);
        boolean test = p.test("Yes");
        System.out.println(test);

        // Function (传入类型，返回类型)
        Function<Integer, Boolean> f = t -> t > 3;
        Boolean apply = f.apply(5);
        System.out.println(apply);

        // Consumer (传入类型)
        Consumer<Integer> c = x -> System.out.println(x * 2);
        c.accept(3);

        // Supplier (返回类型)
        Supplier<String> s = () -> "你好呀！";  // {return "你好呀！";}
        String string = s.get();
        System.out.println(string);
    }
}
