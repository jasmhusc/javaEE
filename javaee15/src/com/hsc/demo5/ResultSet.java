package com.hsc.demo5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    获取表的每一行的信息，打印输出。
 */
public class ResultSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取connection，statement
        Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
        Statement stmt = conn.createStatement();

        // 3. 查询，获取结果
        java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM account;");
        while (rs.next()) {

            // 根据名称获取值，也可以按索引：1，2，3获取
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int balance = rs.getInt("balance");
            System.out.println("id = " + id + " name = " + name + " balance = " + balance);
        }

        // 4. 关闭资源
        stmt.close();
        conn.close();
    }
}
