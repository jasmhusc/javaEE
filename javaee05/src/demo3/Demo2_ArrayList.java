package demo3;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Demo2_ArrayList {

    /*
     *  遍历集合 list 中元素，看看newList中是否含有某些元素，
     *  添加新集合不包含的元素
     *  contains 方法和    remove  方法，底层实现采用的是     equals 方法，判断对象集合时可以修改对象的  equals 方法
     */
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(new Person("Paul", 17));
        list.add(new Person("James", 30));
        list.add(new Person("Paul", 17));
        list.add(new Person("James", 30));
        list.add(new Person("James", 23));
        System.out.println(getSingle(list));
        //System.out.println(list.get(index));    // 根据索引  index 返回list中存储的对象
    }

    public static ArrayList getSingle(ArrayList list) {    // 去除重复元素
        ArrayList newList = new ArrayList();

        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();    // it.next() 只能调用一次     所以即便不需要强转，也需要单独记录其值
            if (!newList.contains(obj))
                newList.add(obj);
        }
        return newList;
    }
}
