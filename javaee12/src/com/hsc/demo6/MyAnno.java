package com.hsc.demo6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解的格式:
 *
 * @interface 注解名 {
 * // 注解属性
 * 数据类型 变量名();
 * }
 * 注解是放一些简单的少量的数据,并不是所有类型都支持
 * 1.8种基本数据类型都可以
 * 2.String,枚举,注解,Class
 * 3.以上类型的一维数组
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {

    String name();

    int age() default 23; // 默认值

    double[] scores();
}

@interface AnnoTest {
    // 空注解
}