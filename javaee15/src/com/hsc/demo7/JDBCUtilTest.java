package com.hsc.demo7;

import com.hsc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试JDBCUtil工具类。
 */
public class JDBCUtilTest {
    public static void main(String[] args) throws SQLException {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test4() throws SQLException {
        // 测试select from
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = conn.createStatement();

        // 插入数据
        int i = stmt.executeUpdate("DELETE FROM category WHERE cid=1;");
        System.out.println("受影响的行数： " + i);

        // 关闭资源
        JDBCUtil.close(conn, stmt);
    }

    private static void test3() throws SQLException {
        // 测试select from
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = conn.createStatement();

        // 删除数据
        ResultSet rs = stmt.executeQuery("SELECT * FROM category;");
        while (rs.next()) {
            int cid = rs.getInt("cid");
            System.out.println("cid = " + cid);
            String cname = rs.getString("cname");
            System.out.println("cname = " + cname);
        }

        // 关闭资源
        JDBCUtil.close(conn, stmt);
    }

    private static void test2() throws SQLException {
        // 测试update set
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = conn.createStatement();

        // 更改'周边手玩'为'电脑平板'
        int i = stmt.executeUpdate("UPDATE category SET cname='电脑平板' WHERE cid=1;");
        System.out.println("受影响的行数： " + i);

        // 关闭资源
        JDBCUtil.close(conn, stmt);
    }

    private static void test1() throws SQLException {
        // 测试insert into
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = conn.createStatement();

        // 插入数据
        int i = stmt.executeUpdate("INSERT INTO category(cname) VALUES('周边手玩');");
        System.out.println("受影响的行数： " + i);

        // 关闭资源
        JDBCUtil.close(conn, stmt);
    }
}
