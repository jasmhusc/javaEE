package demo4;

import java.util.LinkedList;

/*
			class LinkedList {
			    Node<E> first; 第一个节点
				Node<E> last; 最后一个节点
			}

			节点,双向链表
			class Node<E> {
				E item; // 数据域
				Node<E> next; // 下一个节点
				Node<E> prev; // 上一个节点
			}

			LinkedList底层使用的链表.
 */
public class Demo_Node {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("paul");
        list.add("jordan");
        list.add("bryant");
        list.add("paul");
        list.add("carter");
        System.out.println(list);
    }
}
