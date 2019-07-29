package com.hsc.testreflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*
 * 将HashMap中的键值对存入Student,前提是相关属性与Student某些属性是对应的
 * 属性名称都是String类型，如   age，name
 */
public class MapToBean {

    public static void main(String[] args) throws Exception {

        HashMap<String, Object> map = new HashMap<>();

        map.put("name", "李红");
        map.put("id", 201912210);
        map.put("age", 24);

        Student stu = new Student();
        Field[] fields = stu.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();

            Iterator<Entry<String, Object>> it = map.entrySet().iterator();  // 迭代器必须放在此处
            while (it.hasNext()) {
                Entry<String, Object> next = it.next();
                String key = next.getKey();
                Object value = next.getValue();

                if (name.equals(key)) {
                    field.set(stu, value);
                }
            }
        }
        System.out.println(stu);
    }

}
