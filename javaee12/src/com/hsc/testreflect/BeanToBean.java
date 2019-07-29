package com.hsc.testreflect;

import java.lang.reflect.Field;

public class BeanToBean {

    public static void main(String[] args) throws Exception {

        Teacher tea = new Teacher("苍老师", 201912214, 18);
        Student stu = new Student();

        Class<? extends Teacher> cls = tea.getClass();
        Class<? extends Student> clss = stu.getClass();

        Field[] fields = cls.getDeclaredFields();
        Field[] fieldss = clss.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            String simpleName = field.getType().getSimpleName();

            for (Field field2 : fieldss) {
                field2.setAccessible(true);
                String name2 = field2.getName();
                String simpleName2 = field2.getType().getSimpleName();

                if (name.equals(name2) && simpleName.equals(simpleName2)) {
                    field2.set(stu, field.get(tea));
                }
            }
        }

        System.out.println(stu);
    }

}
