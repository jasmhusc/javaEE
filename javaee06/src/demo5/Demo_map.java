package demo5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Map集合特点:
        1.保存键和值
        2.键不能重复
        3.一个键对应一个值

    Entry:
        是一个接口Map内的接口,表示该Map的键值对对象,里面会保存键和值,Entry相当于结婚证

    shift + f6: 重命名
 */
public class Demo_map {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        // put 添加元素
        map.put("黄晓明", "杨颖");
        map.put("李晨", "范冰冰");
        map.put("邓超", "孙俪");
        map.put("谢霆锋", "张柏芝");

        // keySet()遍历查看元素
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            String value = map.get(s);
            System.out.println(s + "::" + value);
        }

        System.out.println("----------------");

        // 再次put键值一样的元素就是修改
        map.put("谢霆锋", "王菲");

        // remove(key)删除元素
        map.remove("李晨");

        /*
         entrySet()遍历查看: 每个entry是一个键值对
          */
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "::" + value);
        }

    }
}
