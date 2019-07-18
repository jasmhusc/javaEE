package demo3;

import java.util.ArrayList;

/*
            public class ArrayList {
                Object[] elementData;

                public ArrayList() {
                    this.elementData = {};
                }

            }

            1.ArrayList内部有一个成员变量Object[] elementData;,ArrayList存储数据就是存到了这个数组中.
            2.在构造方法中,初始化elementData为没有内容的数组
            3.在第一次调用add方法时,数组会初始化为10个长度的数组
            4.调用add方法,当数组的容量不够的时候会进行扩容,新的容量是当前的1.5倍,10 -> 15 -> 22 -> 33
         */
public class Demo_ArrayList {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("paul");
        list.add("james");
        list.add("paul");
        list.add("jordan");
        list.add("bryant");
        list.add("jordan");

    }
}
