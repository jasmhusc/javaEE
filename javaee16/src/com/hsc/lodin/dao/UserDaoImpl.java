package com.hsc.lodin.dao;

import com.hsc.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public void insert(String username, int age, String password) {
        // 获取连接
        try {
            Connection conn = DataSourceUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES (null ,?,?,?);");
            // 设置值
            ps.setString(1, username);
            ps.setInt(2, age);
            ps.setString(3, password);
            // 执行语句
            int result = ps.executeUpdate();
            System.out.println("受影响的行数： " + result);
            // 回收连接到连接池
            DataSourceUtils.close(conn, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        // 获取连接
        try {
            Connection conn = DataSourceUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM user WHERE id=?;");
            // 设置值
            ps.setInt(1, id);
            // 执行语句
            int result = ps.executeUpdate();
            System.out.println("受影响的行数： " + result);
            // 回收连接到连接池
            DataSourceUtils.close(conn, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String password) {
        // 获取连接
        try {
            Connection conn = DataSourceUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE user SET password=?;");
            // 设置值
            ps.setString(1, password);
            // 执行语句
            int result = ps.executeUpdate();
            System.out.println("受影响的行数： " + result);
            // 回收连接到连接池
            DataSourceUtils.close(conn, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findAll() {
        // 获取连接
        try {
            Connection conn = DataSourceUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user;");
            // 执行语句
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                int age = rs.getInt("age");
                String password = rs.getString("password");
                System.out.println(username + "    " + age + "    " + password);
            }
            // 回收连接到连接池
            DataSourceUtils.close(conn, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean query(String username, String password) {
        Boolean isExist = false;
        // 获取连接
        try {
            Connection conn = DataSourceUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username=? AND password=?;");
            // 执行语句
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                isExist = true;
            // 回收连接到连接池
            DataSourceUtils.close(conn, ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }
}
