package demo9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*Collection：集合层次结构中的根接口
* Collection常用功能:
        1.boolean add​(E e) 往集合中添加一个元素
        2.void clear​() 从此集合中删除所有元素
        3.boolean contains​(Object o) 判断集合中是否包含指定的元素
        4.boolean isEmpty​() 判断集合是否为空(没有元素),如果为空返回true
        5.boolean remove​(Object o) 删除集合中的指定元素,如果删除返回true
        6.int size​() 返回此集合中的元素数
        7.Object[] toArray​() 将集合转成数组
        */
public class Demo2_Collection {
    public static void main(String[] args) {

        Collection coll = new ArrayList<>();
        coll.add("王宝强");
        coll.add("贾乃亮");
        coll.add("陈羽凡");
        coll.add("谢霆锋");

//        toArray()
        Object[] obj = coll.toArray();
        for (Object o : obj) {
            System.out.println(o);
        }

        System.out.println("-------");

//      toArray(Object[] obj)  参数为要存进的数组
        Object[] objs = coll.toArray(new String[coll.size()]);
        for (Object o : objs) {
            System.out.println(o);
        }
    }
}
