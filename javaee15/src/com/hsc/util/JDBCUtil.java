package com.hsc.util;

import java.sql.*;

/*
这是一个JDBC的工具类,将JDBC常用,重复的代码放到这个工具类中,别人只要调用方法,更加简单

JDBC工具类实现步骤:
    1.将固定字符串定义为常量
    2.在静态代码块中注册驱动
    3.提供一个获取连接的方法`static Connection getConneciton();`
    4.定义关闭资源的方法`close(Connection conn, Statement stmt, ResultSet rs)`
    5.重载关闭方法`close(Connection conn, Statement stmt)`
 */
public class JDBCUtil {
    // 定义常量
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // static 执行注册驱动
    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
        }
    }

    // 定义获取connection方法
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 定义关闭资源方法
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

    // 重载close()
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }
}
