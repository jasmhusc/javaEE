package com.hsc.demo3;

import com.hsc.utils.DataSourceUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class TestUtils {
    public static void main(String[] args) throws Exception {

        // 从工具类获取连接：connection
        Connection conn = DataSourceUtils.getConnection();

        // 执行SQL语句
        String sql = "SELECT * FROM student;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        // 获取元数据
        ResultSetMetaData metaData = rs.getMetaData();
        int count = metaData.getColumnCount();

        // 反射Student类
        Class<?> aClass = Class.forName("com.hsc.demo3.Student");
        /*
        Object o = aClass.newInstance();
        已过时，用反射得到构造函数创建对象
         */
        Constructor<?> constructor = aClass.getConstructor();

        // 映射Student，list用于存储Student对象。
        ArrayList<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student student = (Student) constructor.newInstance();
            /*
                1. 得到Result的元数据metaData
                2. metaData先获取列数：count
                2. metaData根据索引得到每一列的名称
                3. rs根据列的名称获取对应的值，对student进行赋值。
             */
            for (int i = 1; i <= count; i++) {
                // 获取每一列的值
                String columnName = metaData.getColumnName(i);
                Object value = rs.getObject(columnName);

                // 通过反射获取字段Field，对student赋值
                Field field = aClass.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(student, value);
            }
            // 添加student到list集合
            list.add(student);
        }

        // 输出集合的元素，查看结果
        list.forEach(System.out::println);
    }
}

