package com.hsc.demo4;

import java.sql.*;

/*
    executeUpdate(): 可以执行
        update...set...,insert into...,delete from...
    executeQuery(): 可以执行查询
        select ... from...
 */
public class JDBCDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc");

        // 3. 获取statement，小货车
        Statement stmt = conn.createStatement();

        // 4. 执行sql语句
        // 修改数据
        // String sql1 = "UPDATE category SET cname='计生用品' WHERE cid=2;";

        // 添加
        // String sql2 = "INSERT INTO category(name) VALUES('情趣用品');";
        // int i = stmt.executeUpdate(sql2);
        // System.out.println("受影响的行数： " + i); // 1

        // 查询
        String sql3 = "SELECT * FROM category WHERE cid=1;";
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            // 以索引获取值
            int cid = rs.getInt(1);
            System.out.println("cid = " + cid);

            // 以名称获取值
            String name = rs.getString("name");
            System.out.println("name = " + name);
        }

        // 删除
        String sql4 = "DELETE FROM category WHERE cid = 1;";
        int i = stmt.executeUpdate(sql4);
        System.out.println("受影响的行数： " + i);
    }
}
