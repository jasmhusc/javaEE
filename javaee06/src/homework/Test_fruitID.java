package homework;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Test_fruitID {
    public static void main(String[] args) {

        // 创建Fruit类，用于创建水果对象，包含水果的基本属性

        // 创建map集合，存储水果id和水果对象
        HashMap<String, Fruit> map = new HashMap<String, Fruit>();

        // 四种水果对应不同8个商品号码，号码不能重复
//        String id = createId(8);

        addFruit(map, "苹果");
        addFruit(map, "香蕉");
        addFruit(map, "橘子");
        addFruit(map, "西瓜");

        // 打印结果
        System.out.println(map);
    }

    // 添加水果，定义添加函数 addFruit()
    private static void addFruit(HashMap<String, Fruit> map, String s) {
        String id = createId(8);
        Set<String> keySet = map.keySet();
        while (true) {
            if (!keySet.contains(id)) {
                map.put(id, new Fruit(s));
                break;
            } else {
                id = createId(8);
            }
        }

    }

    // 定义一个生产商品号的函数： createId()
    private static String createId(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 循环n次
            sb.append(new Random().nextInt(10));
        }
        // 返回字符串id
        return sb.toString();
    }
}
