package demo6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo_hashmap {
    public static void main(String[] args) {

        HashMap<Player, String> map = new HashMap<>();
        map.put(new Player("樱木花道", 59), "湘北");
        map.put(new Player("流川枫", 49), "北海道");
        map.put(new Player("宫城良田", 79), "东京");
        // 遍历查看
        Set<Map.Entry<Player, String>> entries = map.entrySet();
        for (Map.Entry<Player, String> entry : entries) {
            System.out.println(entry.getKey().getName() + "::" + entry.getValue());
        }
        System.out.println("----------------------");

        // 添加重复元素，查看结果
        map.put(new Player("流川枫", 63), "广岛");
        map.put(new Player("三井寿", 73), "北海道");

        // 遍历 添加变成修改
        Set<Player> keySet = map.keySet();
        for (Player player : keySet) {
            System.out.println(player.getName() + "::" + player.getScore() + "::" + map.get(player));
        }
    }
}
