package demo1;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Collection接口定义了iterator()方法
 * 其实现类均有迭代器方法，Collection集合元素的通用获取方式
 * */
public class DemoIterator {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("马蓉");
        list.add("张柏芝");
        list.add("白百合");
        list.add("李小璐");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            /* 循环内只能取一次
              NoSuchElementException没有集合元素异常
             */
            String s = it.next();
            System.out.println(s);
        }
    }
}
