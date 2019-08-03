package com.hsc.demo8;

import com.hsc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * sql注入问题：用直接拼接sql的方式存在安全问题。
 * 用户名：*
 * 密码：*' or '1'='1
 */
public class Loadin1 {
    public static void main(String[] args) throws SQLException {
        // 1.使用数据库保存用户的账号和密码
        // 2.让用户输入账号和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号:");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();

        // 3.使用SQL根据用户的账号和密码去数据库查询数据
        String sql = "SELECT * FROM user WHERE username='" + username + "'AND password='" + password + "';";
        Connection conn = JDBCUtil.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            System.out.println("恭喜您，" + username + "登录成功");
        } else {
            System.out.println("用户名或密码错误!");
        }

        // 关闭资源
        st.close();
        conn.close();
    }
}
