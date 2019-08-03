package com.hsc.demo3;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
        DriverManager类: static Connection getConnection(String url, String user, String password) 获取连接
        1.`String url`：连接数据库的URL，用于说明连接数据库的位置
        2.`String user`：数据库的账号
        3.`String password`：数据库的密码
         */
        // 1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取connection (连本机3306端口则可以省略)
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
        System.out.println("conn = " + conn);

        // 3. 获取statement，用于执行sql语句，属性配置对象
        Statement stmt = conn.createStatement();
        System.out.println("stmt = " + stmt);
    }
}
