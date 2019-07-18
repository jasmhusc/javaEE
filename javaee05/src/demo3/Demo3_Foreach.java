package demo3;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo3_Foreach {

    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();

        list.add("a");
        boolean a = list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("a");
        System.out.println(a);
		
		/* 1.普通迭代器删除
		for (int i = 0; i < list.size(); i++) {
//			if("a".equals(list.get(i)))               // 移除一个元素后列表所有元素向前移动一位
//				list.remove(i);                       // 不相邻的可以全部移除，相邻的则少移除一个
//			if("b".equals(list.get(i)))
//			    list.remove(i);                 // b会保留一个
			if("b".equals(list.get(i)))
			    list.remove(i--);           // 移除后回退一位，保证所有元素都会被检测
		  }
        System.out.println(list);   */

        // 2.Iterator迭代器删除
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if ("b".equals(it.next()))
                it.remove();
        }
        System.out.println(list);
		
		/* 3. 增强for循环
		for (String string : list) {
			
		    if("b".equals(string))
		    	list.remove("b");                   
		}
		System.out.println(list);  */
    }
}