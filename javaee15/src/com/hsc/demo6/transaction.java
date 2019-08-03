package com.hsc.demo6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    事务回滚
 */
public class transaction {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        // 事务
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///jdbc");
            // 3. 关闭自动提交事务，开启事务
            conn.setAutoCommit(false);
            // 4. 获取statement，小货车
            stmt = conn.createStatement();

            // 5. 执行sql语句，张三账户减少500rmb
            stmt.executeUpdate("UPDATE account SET balance=balance-500 WHERE name='张三';");

            // 6. 模拟转账失败
            int i = 100 / 0;

            // 7. 李四账户增加500rmb
            stmt.executeUpdate("UPDATE account SET balance=balance+500 WHERE name='李四';");

        } catch (Exception e) {
            // 异常就事务回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("事务回滚失败");
            }
            System.out.println("事务回滚");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
