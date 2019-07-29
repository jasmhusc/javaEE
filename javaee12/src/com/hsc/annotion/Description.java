package com.hsc.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解  Description
@Target({ElementType.METHOD, ElementType.TYPE})  // 作用域：类前和函数前
@Documented      // 文档注解
@Inherited      // 可继承
@Retention(RetentionPolicy.RUNTIME)  // 生命周期：运行阶段
public @interface Description {

    /*
     * 1.成员变量类型受限，  基本类型，string ,class Annotation
     * 2.只有一个成员变量，则成员名称用 value(),使用时可以忽略成员名  value()和 =
     * 3.没有成员变量，则为标识注解
     */
    String desc();   // 在注解里只是一个成员变量，并不是函数

    String author();

    int age() default 18;  // 成员变量可以指定默认值
}