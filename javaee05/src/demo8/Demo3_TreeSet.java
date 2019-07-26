package demo8;

import demo3.Person;

import java.util.Comparator;
import java.util.TreeSet;

public class Demo3_TreeSet {
    public static void main(String[] args) {

        //demo1();
        // Person中必须实现Comparable接口，并重写CompareTo方法，这样TreeSet才知道如何排序
        // compareTo方法返回 0，集合只存储一个；返回正数，集合按顺序存储；返回负数，集合倒序存储          从树枝---树干----树根
        //demo2();
        // TreeSet 可以传入比较器对象，即   Comparator c = new CompareByLen();   ComparaByLen是继承了该接口的子类
        // String 类本身就已经实现了  Comparable接口，并重写CompareTo方法，会去除重复，结果默认按照 字典排序
        // 我们传入  一个Comparator比较器，则优先使用我们的。
        TreeSet<String> ts = new TreeSet<String>(new CompareByLen());
        // add()方法会自动调用  比较器Comparator 中的  Compare 方法进行排序
        boolean aa = ts.add("aaaaa");
        ts.add("zz");
        ts.add("j");
        ts.add("ccc");
        ts.add("e");
        System.out.println(aa);
        System.out.println(ts);

    }

    public static void demo2() {
        // 自定义类必须实现   comparable 接口，成为其子类，并重写里面的  compareTo方法
        // TreeSet 中的 add()方法会将存入的对象 提升为  Comparable 类型
        TreeSet<Person> p = new TreeSet<>();
        p.add(new Person("Paul", 17));
        p.add(new Person("James", 30));
        p.add(new Person("Paul", 17));
        p.add(new Person("Jane", 30));
        p.add(new Person("Jane", 43));

        System.out.println(p);
    }

    public static void demo1() {
        TreeSet<Integer> list = new TreeSet<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(3);

        System.out.println(list);
    }
}

class CompareByLen implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
//      先按照字符串长度排序，再按照自然方式排序
        int num = o1.length() - o2.length();
        return num == 0 ? o1.compareTo(o2) : num;
//        return 0; 只会存第一个字符串aaaaa，后面的都不会存
    }
}
