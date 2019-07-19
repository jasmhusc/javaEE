package demo7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map计算字符串中的字符出现次数
 */
public class Demo_test1 {
    public static void main(String[] args) {

        String s = "bzcbzaabAaacb";
        HashMap<Character, Integer> map = new HashMap<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            // 获得每一个字符
            char c = s.charAt(i);
            // 添加到Map集合，可以自动去重，但需要在重复的时候让个数增加
            if (map.keySet().contains(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        // 查看结果
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
    }
}
