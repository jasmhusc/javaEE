package com.hsc.demo9;

import com.hsc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用PreparedStatement实现增删查改
 * 添加数据: 向Employee表添加3条记录
 * 修改数据: 将第2个学生地址改成湘北
 * 删除数据: 删除第2个学生
 */
public class Demo1 {
    public static void main(String[] args) throws SQLException {

        //添加数据
//        testInsert();
        // 修改数据
//        testUpdate();
        // 删除数据
        testDelete();
    }

    private static void testInsert() throws SQLException {
        // 向Employee表添加3条记录
        // 获取连接
        Connection conn = JDBCUtil.getConnection();
        String sql = "INSERT INTO student VALUE (?,?,?);";
        PreparedStatement pst = conn.prepareStatement(sql);

        // 设置值1
        pst.setString(1, "樱木花道");
        pst.setInt(2, 18);
        pst.setString(3, "和光中学");

        // 执行sql
        int i = pst.executeUpdate();
        System.out.println(i + "行受影响");

        // 设置值2
        pst.setString(1, "赤木晴子");
        pst.setInt(2, 16);
        pst.setString(3, "四中");

        // 执行sql
        int i2 = pst.executeUpdate();
        System.out.println(i2 + "行受影响");

        // 设置值3
        pst.setString(1, "流川枫");
        pst.setInt(2, 17);
        pst.setString(3, "神奈川中学");

        // 执行sql
        int i3 = pst.executeUpdate();
        System.out.println(i3 + "行受影响");

        // 关闭资源
        JDBCUtil.close(conn, pst);
    }

    private static void testUpdate() throws SQLException {
        // 将id为2的学生地址改成台湾
        // 获取连接
        Connection conn = JDBCUtil.getConnection();
        String sql = "UPDATE student SET address=? WHERE name=?;";
        PreparedStatement pst = conn.prepareStatement(sql);

        // 设置值
        pst.setString(1, "湘北高中");
        pst.setString(2, "赤木晴子");

        // 执行sql，关闭资源
        int i = pst.executeUpdate();
        System.out.println(i + "行受影响");
        JDBCUtil.close(conn, pst);
    }

    private static void testDelete() throws SQLException {
        // 删除id为2的员工
        // 获取连接
        Connection conn = JDBCUtil.getConnection();
        String sql = "DELETE FROM student WHERE name=?";
        PreparedStatement pst = conn.prepareStatement(sql);

        // 设置值
        pst.setString(1, "赤木晴子");

        // 执行sql，关闭资源
        int i = pst.executeUpdate();
        System.out.println(i + "行受影响");
        JDBCUtil.close(conn, pst);
    }
}
