package com.hsc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Durid连接池工具类
 */
public class DataSourceUtils {
    // 1.声明静态连接池成员变量
    static DataSource ds;

    // 2.创建连接池对象
    static {
        // 加载properties文件：druid.properties
        Properties pp = new Properties();
        // 创建流对象
        InputStream in = DataSourceUtils.class.getResourceAsStream("/druid.properties");
        // 加载properties
        try {
            pp.load(in);
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3.连接获取接口
    public static Connection getConnection() throws Exception {
        Connection conn = ds.getConnection();
        return conn;
    }

    // 4.关闭连接，回收资源
    public static void close(Connection conn, Statement st, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }

    }

    public static void close(Connection conn, Statement st) {
        close(conn, st, null);
    }
}
