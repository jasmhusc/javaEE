package com.hsc.demo7;

import java.lang.annotation.Annotation;

/**
 * 注解解析?
 * 在程序运行的时候,得到注解里面属性值
 * <p>
 * 注解解析相关接口?
 * AnnotatedElement接口定义了解析注解的方法
 * T getAnnotation​(Class<T> annotationClass) 获取某个对象上的单个注解
 * Annotation[] getAnnotations​() 获取某个对象上的所有注解
 * boolean isAnnotationPresent​(Class annotationClass) 判断是否有这个注解
 * <p>
 * Class, Constructor, Method, Field 都实现了AnnotatedElement接口.
 * <p>
 * 解析注解?
 * 注解在谁头上就用谁来获取
 * 假如注解在构造方法上,使用Constructor来获取
 * 假如注解在成员方法上,使用Method来获取
 * 假如注解在成员变量上,使用Field来获取
 */
public class BookAnnoDemo {
    public static void main(String[] args) throws Exception {

        /*
         解析BookShelf上的注解
          */
        // 1. 获取.class对象
        Class<BookShelf> aClass = BookShelf.class;
        BookShelf obj = aClass.newInstance();


        // 2. 获取所有Annotation
        Annotation[] annos = aClass.getAnnotations();

        // 3.遍历所有注解，判断是否有BookAnno注解
        for (Annotation anno : annos) {
            boolean b = aClass.isAnnotationPresent(BookAnno.class);
        }
    }
}
