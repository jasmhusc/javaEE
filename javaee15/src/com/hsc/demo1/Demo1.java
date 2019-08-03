package com.hsc.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    体验JDBC
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. 注册驱动（静态代码块加载，自动注册）
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
        System.out.println("conn = " + conn);

        // 3. 获取statement 小货车
        Statement stmt = conn.createStatement();

        // 4. 编写sql语句，执行语句
        String sql = "INSERT INTO account (name,balance) VALUES ('张三',1000);";
        int i = stmt.executeUpdate(sql);
        System.out.println("受影响的行数： " + i);

        // 关闭资源
        stmt.close();
        conn.close();
    }
}
