package demo3;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo1_ArrayList {
    /*
     *  遍历集合 list 中元素，看看newList中是否含有某些元素，
     *  添加新集合不包含的元素
     */


    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        ArrayList newList = new ArrayList();
        list.add("paul");
        list.add("james");
        list.add("westbrook");
        newList.add("curry");
        newList.add("james");
        System.out.println(getSingle(newList, list));
    }

    public static ArrayList getSingle(ArrayList newList, ArrayList list) {     // 求两个集合并集

        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (!newList.contains(obj))
                newList.add(obj);
        }
        return newList;
    }

}
