package com.hsc.reflect;

/*
 *  反射获取Class类实例的三种方式
 *     第一种方式:
 *         对象.getClass()
 *         例如： Class cls = new Student().getClass();
 *     第二种方式：
 *         类名.Class
 *         例如： Class cls = Student.Class;
 *     第三种方式：(常用，推荐使用)
 *         Class.forName("全限定名")
 *         使用Class类的静态方法  forName("包名.类名")方法
 *         例如： Class cls = Class.forName("reflect.Goods");
 */
public class Case1 {

    public static void main(String[] args) throws Exception {
        // 获取Goods运行时类
        Class<?> cls1 = Goods.class;

        // 必须有Goods类且必须创建对象，不常用
        Class<? extends Goods> cls2 = new Goods().getClass();

        Class<?> cls3 = Class.forName("reflect.Goods");
    }
}
