package com.hsc.demo7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*  @Target
    作用：用来标识注解使用的位置，如果没有使用该注解标识，则自定义的注解可以使用在任意位置。
    可使用的值定义在ElementType枚举类中。

    @Retention
    作用：用来标识注解的生命周期(有效范围)
    可使用的值定义在RetentionPolicy枚举类中。
        SOURCE: 源代码阶段
        CLASS: class阶段
        RUNTIME: 运行时阶段
 */
// @Target(ElementType.CONSTRUCTOR) 让注解可以在构造函数上使用
// @Target(ElementType.FIELD)   让注解可以在成员变量上使用
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MetaAnno {
}
