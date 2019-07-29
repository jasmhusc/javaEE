package com.hsc.demo7;

import org.junit.Test;

/*
    为BookShelf添加注解
 */
@BookAnno(name = "红楼梦", price = 38.9, authors = {"曹雪芹"})
public class BookShelf {

    @Test
    @BookAnno(name = "西游记", authors = {"吴承恩", "白求恩"}, price = 200)
    // 注解上的数据,在任何地方都可以解析出来(灵活)
    public void showBook(String name, double price) {

        // 方法参数上的数据,只能在这个方法里面得到
        System.out.println("showbook: ");
        System.out.println("书名： " + name + ", 价格" + price + "rmb");
    }
}
