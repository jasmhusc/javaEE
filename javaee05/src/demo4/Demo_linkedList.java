package demo4;

import java.util.LinkedList;

/*
LinkedList的底层:
		是链表，可以对索引操作，更多是对首位元素操作，这是他的特有方法

	LinkedList特有方法:
		void addFirst​(E e) 在该列表开头插入指定的元素。
		void addLast​(E e) 将指定的元素追加到此列表的末尾。
		E getFirst​() 返回此列表中的第一个元素。
		E getLast​() 返回此列表中的最后一个元素。
		E removeFirst​() 从此列表中删除并返回第一个元素。
		E removeLast​() 从此列表中删除并返回最后一个元素。
 */
public class Demo_linkedList {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("paul");
        list.add("james");
        list.add("paul");
        list.add("jordan");
        list.add("bryant");
        System.out.println(list);

        // 获取首尾元素
        System.out.println("head:" + list.getFirst());
        System.out.println("tail:" + list.getLast());

        // 对首尾元素添加操作,add默认在尾部添加
        list.add("macgrady");
        list.addFirst("张伯伦1");
        list.addLast("张伯伦2");
        System.out.println(list);

        // 对元素进行设置操作
        list.set(3, "carter");
        System.out.println(list);

        // 对首尾元素进行删除操作,指定索引删除
        list.removeFirst();
        list.remove(6);
        System.out.println(list);
    }
}
