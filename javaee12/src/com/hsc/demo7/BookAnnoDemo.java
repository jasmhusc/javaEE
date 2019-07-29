package com.hsc.demo7;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 注解解析?
 * 在程序运行的时候,得到注解里面属性值
 * <p>
 * 注解解析相关接口?
 * AnnotatedElement接口定义了解析注解的方法:
 * 1. T getAnnotation​(Class<T> annotationClass) 获取某个对象上的单个注解
 * 2. Annotation[] getAnnotations​() 获取某个对象上的所有注解，包含父类
 * 3. Annotation[]  getDeclaredAnnotations() 只包含本类的
 * 4. boolean isAnnotationPresent​(Class annotationClass) 判断是否有这个注解
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

    @Test
    public void testClass() {
    /*
         解析BookShelf类上的注解
          */
        // 1. 获取该类的.class对象
        Class<BookShelf> aClass = BookShelf.class;

        // 2. 获取所有Annotation
        Annotation[] annos = aClass.getAnnotations();

        // 3.遍历所有注解，判断是否有BookAnno注解
        boolean b = aClass.isAnnotationPresent(BookAnno.class);
        if (b) {
                /*
                 如果BookShelf类上存在BookAnno注解，就得到他，在获取里面的属性和值
                  */
            BookAnno an = aClass.getAnnotation(BookAnno.class);

            // 获得书名
            System.out.println(an.name());
            // 获得价格
            System.out.println(an.price());
            // 获得作者
            String[] authors = an.authors();
            System.out.println(Arrays.toString(authors));
        } else {
            System.out.println("类BookShelf上没有BookAnno注解！");
        }
    }

    @Test
    public void testMethod() throws Exception {
        // 获取.class对象
        Class<?> aClass = Class.forName("com.hsc.demo7.BookShelf");

        // 反射获取method：showBook
        Method method = aClass.getMethod("showBook", String.class, double.class);

        // 判断方法是否存在BookAnno注解
        boolean b = method.isAnnotationPresent(BookAnno.class);
        if (b) {
            // 打印注解信息
            BookAnno anno = method.getAnnotation(BookAnno.class);
            System.out.println("书名： " + anno.name() + ", 价格： " + anno.price());
        }

        // 输出该方法上所有注解
        Annotation[] annos = method.getAnnotations();
        for (Annotation anno : annos) {
            System.out.println(anno);
        }
    }
}
