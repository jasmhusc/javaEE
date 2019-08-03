package com.hsc.demo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecute {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 执行其他sql语句
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbc");
        Statement st = conn.createStatement();

        // Alter ctrl+shift+u 切换大小写
        // 改变列的名称
        String sql = "ALTER TABLE category CHANGE name cname VARCHAR(20) NOT NULL;";
        boolean b = st.execute(sql);
        System.out.println("b = " + b); // b = false 更改成功？

        // 关闭资源
        st.close();
        conn.close();
    }
}
