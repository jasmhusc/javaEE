package com.hsc.demo8;

import com.hsc.util.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

/**
 * 用PreparedStatement:
 * 直接与查询结果比较，可以避免sql注入。
 * 提前编译sql语句，可以对此设值执行，提高效率。
 */
public class Loadin2 {
    public static void main(String[] args) throws SQLException {

        // 1.使用数据库保存用户的账号和密码
        // 2.让用户输入账号和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号:");
        String username = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();

        // 3.使用SQL根据用户的账号和密码去数据库查询数据
        String sql = "SELECT * FROM user WHERE username=?AND password=?;";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);

        // 设值
        pst.setString(1, username);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            System.out.println("恭喜您，" + username + "登录成功");
        } else {
            System.out.println("用户名或密码错误!");
        }

        // 关闭资源
        pst.close();
        conn.close();
    }
}
