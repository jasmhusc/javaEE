package com.hsc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HuscLove
 * 约束注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {

    // 三种约束：主键，非空，唯一，自动增长
    boolean primaryKey() default false;

    boolean allowNull() default false;

    boolean unique() default false;

    boolean autoIncrement() default false;
}
