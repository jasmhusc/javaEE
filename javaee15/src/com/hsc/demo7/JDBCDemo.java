package com.hsc.demo7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
import com.hsc.util.JDBCUtil;

/**
 * @author 使用 junit进行单元测试
 */
public class JDBCDemo {
    @Test
    public void TestQuery() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // 1.注册驱动
            conn = JDBCUtil.getConnection();
            // 2.创建 属性配置对象
            st = conn.createStatement();
            // 3.执行sql语句
            String sql = "select * from t_stu";
            st.executeQuery(sql);
            // 获取结果集
            rs = st.getResultSet();
            // 遍历获取数据
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("id: " + id + "  name: " + name + "  age: " + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, st, rs);
        }
    }

    @Test
    public void TestInsert() {
        Connection conn = null;
        Statement st = null;

        try {
            // 1.注册驱动
            conn = JDBCUtil.getConnection();
            // 2.创建 属性配置对象
            st = conn.createStatement();
            // 3.执行sql语句 添加 返回影响的行数 大于0表示添加成功
            String sql = "insert into t_stu values(null,'aobama',59)";
            int result = st.executeUpdate(sql);
            if (result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, st);
        }
    }

    @Test
    public void TestDelete() {
        Connection conn = null;
        Statement st = null;

        try {
            // 1.注册驱动
            conn = JDBCUtil.getConnection();
            // 2.创建 属性配置对象
            st = conn.createStatement();
            // 3.执行sql语句 添加 返回影响的行数 大于0表示添加成功
            String sql = "delete from t_stu where name='aobama'";
            int result = st.executeUpdate(sql);
            if (result > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, st);
        }
    }

    @Test
    public void TestUpdate() {
        Connection conn = null;
        Statement st = null;

        try {
            // 1.注册驱动
            conn = JDBCUtil.getConnection();
            // 2.创建 属性配置对象
            st = conn.createStatement();
            // 3.执行sql语句 添加 返回影响的行数 大于0表示添加成功
            String sql = "update t_stu set age=27 where name='kevin'";
            int result = st.executeUpdate(sql);
            if (result > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, st);
        }
    }
}
