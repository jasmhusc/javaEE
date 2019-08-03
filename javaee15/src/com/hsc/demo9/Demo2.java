package com.hsc.demo9;

import com.hsc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 查询id小于4的员工信息,并保存到员工类中.
 */
public class Demo2 {
    public static void main(String[] args) throws SQLException {

        // 获取连接
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT * from employee where id<?;";
        PreparedStatement pst = conn.prepareStatement(sql);

        // 查询结果
        pst.setInt(1, 4);
        ResultSet rs = pst.executeQuery();

        // 遍历
        ArrayList<Employee> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            // 创建对象
            Employee e = new Employee(id, name, age, address);
            // 添加到集合
            list.add(e);
        }

        // 打印输出。
        JDBCUtil.close(conn, pst);
        list.forEach(System.out::println);
    }
}
