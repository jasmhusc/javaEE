package demo6;

import java.util.HashSet;

/*
 * HashSet:
 *   1. 无索引
 *   2. 取出无序
 *   5. 不能重复
 *   3. 不能修改值
 *   4. 不能获得单个元素
 *   6. 遍历使用迭代器和增强for循环
 **/
public class DemoSet {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("西施");
        hashSet.add("貂蝉");
        hashSet.add("王昭君");
        hashSet.add("西施");

        System.out.println(hashSet);

        for (String s : hashSet) {
            System.out.println(s);
        }
    }

}
