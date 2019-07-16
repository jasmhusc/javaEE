package demo9;

public class Demo1_Math {

    public static void main(String[] args) {

        System.out.println(Math.PI);         // 圆周率
        System.out.println(Math.abs(-24));   // 取绝对值

        System.out.println(Math.floor(12.34));   // 向下取整，但是结果为 double
        System.out.println(Math.ceil(12.56));    // 向上取整，但是结果为 double

        System.out.println(Math.max(23, 12));    //取最值 max
        System.out.println(Math.min(23, 12));    //取最值 min
        System.out.println(Math.pow(3, 2));   // 幂运算 结果为 double

        System.out.println(Math.random());    // 0.0-1.0之间,含0.0，不含1.0
        System.out.println(Math.round(12.3f));   // 四舍五入
        System.out.println(Math.sqrt(64));     // 开方

    }

}
  