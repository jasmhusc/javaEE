package demo6;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型：
 * 对象存储集合后，会被提升成Object类型。
 * 当我们在取出每一个对象，并且进行相应的操作，这时必须采用类型转换。
 */
public class GenericDemo {
    public static void main(String[] args) {
//      指定泛型，遍历时不用转型
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("dfg");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().length());
        }
//       不指定泛型，遍历时要转型
        ArrayList list1 = new ArrayList();
        list.add("abc");
        list.add("dfg");

        Iterator it1 = list.iterator();
        while (it1.hasNext()) {
            // 使用泛型,不合格的数据无法添加.
            // 不需要强转,避免强制类型转换带来的失败问题
            String s = (String) it1.next();
            System.out.println(s.length());
        }
    }
}
