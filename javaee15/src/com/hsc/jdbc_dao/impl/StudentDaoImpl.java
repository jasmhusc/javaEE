package com.hsc.jdbc_dao.impl;

import com.hsc.jdbc_dao.StudentDao;
import com.hsc.util.JDBCUtil;

import java.sql.*;

/**
 * StudentDao接口的实现类，动态代理类。
 */
public class StudentDaoImpl implements StudentDao {
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    @Override
    public void insert(String username, int age, String password) {
        // 插入数据
        try {
            // 创建连接
            conn = JDBCUtil.getConnection();
            String sql = "INSERT into t_stu VALUE (null ,?,?,?);";
            ps = conn.prepareStatement(sql);
            // 设置数据值
            ps.setString(1, username);
            ps.setInt(2, age);
            ps.setString(3, password);
            // 执行sql
            int result = ps.executeUpdate();
            if (result > 0)
                System.out.println("添加成功");
            else
                System.out.println("添加失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps);
        }
    }

    @Override
    public void delete(int id) {
        // 更新数据
        try {
            // 创建连接
            conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM t_stu WHERE id=?;";
            ps = conn.prepareStatement(sql);
            // 执行sql
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            // 判断
            if (result > 0)
                System.out.println("删除成功");
            else
                System.out.println("删除失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps);
        }
    }

    @Override
    public void update(int id, String password) {
        // 更新数据
        try {
            // 创建连接
            conn = JDBCUtil.getConnection();
            String sql = "UPDATE t_stu SET password=? WHERE id=?;";
            ps = conn.prepareStatement(sql);
            // 执行sql
            ps.setString(1, password);
            ps.setInt(2, id);
            int result = ps.executeUpdate();
            // 判断
            if (result > 0)
                System.out.println("更新成功");
            else
                System.out.println("更新失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps);
        }
    }

    @Override
    public void findAll() {
        // 查询数据
        try {
            // 创建连接
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * from t_stu;";
            ps = conn.prepareStatement(sql);
            // 执行sql
            rs = ps.executeQuery();
            // 遍历打印
            while (rs.next()) {
                String username = rs.getString("username");
                int age = rs.getInt("age");
                System.out.println(username + "   " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps);
        }
    }

    @Override
    public void loadin(String username, String password) {
        // 执行登录
        try {
            // 创建连接
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * from t_stu WHERE username=? and password=?;";
            ps = conn.prepareStatement(sql);
            // 设置数据值
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            // 执行sql
            if (rs.next())
                System.out.println("恭喜您，" + username + "登录成功");
            else
                System.out.println("登录失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps);
        }
    }
}
