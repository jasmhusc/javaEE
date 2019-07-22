package demo1;

/*
 * 1. 如果多个接口定义了相同的 static 方法，一个类又同时实现以上多个接口，因为是用 接口名.方法名 调用，不会报错；
 *    如果是 default 方法，则在实现类中可以重写该方法，也可以直接创建对象调用。
 * 2. 默认方法：可扩展性，可选性
 * 3. 静态方法：不需要实现接口，不需要创建实例，直接调用
 */
public interface Demo_Interface {

    // abstract--抽象方法
    void fun1();

    // static--静态方法，必须有方法体，接口名.fun2()
    static void fun2() {

        System.out.println("static function in interface");
    }

    // default--默认方法，必须有方法体，子类可以重写
    default void fun3() {

        System.out.println("default function in interface");
    }
}
