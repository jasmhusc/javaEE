package demo4;

import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) {
        // 抽象类继承Object
        /*Method[] methods = DemoAbstract.class.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }*/

        // interface是否继承Object？输出看不到
        Method[] methods = DemoInterface.class.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }
}
