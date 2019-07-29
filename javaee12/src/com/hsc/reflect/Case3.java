package com.hsc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
 * 获取成员变量
 */
public class Case3 {

    public static void main(String[] args) throws Exception {
        // 获取运行时类
        Goods g = new Goods();
        Class<? extends Goods> class1 = g.getClass();

        Goods goods = new Goods("洗发水", 12.2, 250);

        System.out.println("----------------------------class.getDeclaredFields-------------------------------");
        Field[] fields = class1.getDeclaredFields();
        // 对属性进行遍历
        for (Field field : fields) {
            field.setAccessible(true);
            // 获取访问修饰符
            int modifiers = field.getModifiers();
            String string = Modifier.toString(modifiers);

            // 获取属性类型
            Class<?> type = field.getType();
            String simpleName = type.getSimpleName();

            // 获取属性名称
            String name = field.getName();

            // 获取属性值
            Object value = field.get(goods);
            System.out.println(string + " " + simpleName + " " + name + " " + value);

            // 设置属性值
            if ("name".equals(name)) {
                field.set(goods, "洗面奶");
            } else if ("price".equals(name)) {
                field.set(goods, 34.8);
            } else if ("storage".equals(name)) {
                field.set(goods, 1000);
            }
        }
        System.out.println(goods);

        System.out.println("--------------------------class.getDeclaredField(String name)---------------------------");
        Field field = class1.getDeclaredField("name");
        field.setAccessible(true);
        field.set(goods, "洗洁精");
        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName() + " " + field.get(goods));

        System.out.println("--------------------------class.getFields---------------------------");
        Field[] fields2 = goods.getClass().getFields();
        // 对属性进行遍历
        for (Field field2 : fields2) {
            field2.setAccessible(true);
            System.out.println(Modifier.toString(field2.getModifiers()) + " " + field2.getType().getSimpleName() + " " + field2.getName() + " " + field2.get(goods));
        }
    }
}