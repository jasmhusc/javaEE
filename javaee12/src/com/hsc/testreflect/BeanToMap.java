package com.hsc.testreflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 将Teacher属性名称和对应的值存入 HashMap中
 */
public class BeanToMap {

    public static void main(String[] args) throws Exception {

        Teacher tea = new Teacher("苍老师", 201912214, 18);

        Class<? extends Teacher> cls = tea.getClass();

        Field[] fields = cls.getDeclaredFields();

        Map<String, Object> hashMap = new HashMap<>();

        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(tea);

            hashMap.put(name, value);
        }

        Set<Entry<String, Object>> entryset = hashMap.entrySet();
        Iterator<Entry<String, Object>> iterator = entryset.iterator();

        while (iterator.hasNext()) {
            Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();

            System.out.println("Key:" + key + " " + "Value:" + value);
        }

    }

}
