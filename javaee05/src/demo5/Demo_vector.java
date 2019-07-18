package demo5;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/*
1.Vector的特点?
      Vector底层使用的是数组,有序,有索引,类似ArrayList,Vector线程安全,效率低

2.Enumeration的作用?
      相当于迭代器,可以获取集合的元素

3.Enumeration的2个方法?
      hasMoreElements: 判断是否有下一个元素
      nextElement(): 获取下一个元素
 */
public class Demo_vector {
    public static void main(String[] args) {

        Vector<String> vector = new Vector<>();
        vector.add("李白");
        vector.add("杜甫");
        vector.add(1, "白居易");

        // 遍历，iterator的前身--Enumeration
        Enumeration<String> enu = vector.elements();
        while (enu.hasMoreElements()) {
            String s = enu.nextElement();
            System.out.println(s);
        }
    }
}
