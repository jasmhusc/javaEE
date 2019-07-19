package demo7;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Demo_test2 {
    public static void main(String[] args) {

        TreeMap<String, String> map = new TreeMap<>();
        map.put("百度知道", "http://www.baidu.com/");
        map.put("360好搜", "http://www.360haosou.com/");
        map.put("Google", "http://www.google.com/");

        // 查看结果
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
    }
}
