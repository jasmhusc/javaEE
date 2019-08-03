package com.hsc.demo10;

import com.hsc.demo9.Employee;
import com.hsc.util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

/**
 * 使用结果集元数据对结果进行自动封装:
 * 要求：
 * mysql中的元数据名称与类的对应名称相同
 */
public class Demo10 {
    public static void main(String[] args) throws Exception {
        // 获取连接
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT * from employee;";
        PreparedStatement pst = conn.prepareStatement(sql);

        // 获取结果集
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData md = rs.getMetaData();

        // 遍历
        Class<?> aClass = Class.forName("com.hsc.demo9.Employee");
        ArrayList<Employee> list = new ArrayList<>();
        int count = md.getColumnCount();
        while (rs.next()) {
            Employee e = new Employee();
            for (int i = 1; i <= count; i++) {
                // 获取元数据名称和对应的值
                String columnName = md.getColumnName(i);
                Object value = rs.getObject(columnName);

                // 反射，给e成员变量赋值
                Field field = aClass.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(e, value);
            }
            list.add(e);
        }

        // 打印list
        list.forEach(System.out::println);
    }
}
