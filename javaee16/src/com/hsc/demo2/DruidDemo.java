package com.hsc.demo2;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 1.导入druid的jar包;
 * 2.在src目录下创建一个properties文件，并设置对应参数;
 * 3.加载properties文件的内容到Properties对象中;
 * 类路径: 资源一定要放在src下面, /表示src.
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {

        // 1. 加载配置文件：druid.properties
        Properties pp = new Properties();
        // 相对于src目录
        InputStream is = DruidDemo.class.getResourceAsStream("/druid.properties");
        pp.load(is);
        // 2. 创建连接池，使用配置中的参数
        DataSource ds = DruidDataSourceFactory.createDataSource(pp);
        Connection conn = ds.getConnection();

        // 3.1. 执行sql命令1
        String sql = "INSERT INTO student VALUES (null ,?,?,?);";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "如花");
        pstmt.setInt(2, 16);
        pstmt.setDouble(3, 88.6);
        int result = pstmt.executeUpdate();
        System.out.println("受影响的行数： " + result);
        // 3.2 执行sql命令2
        sql = "SELECT * FROM student;";
        ResultSet rs = pstmt.executeQuery(sql);
        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            double score = rs.getDouble("score");
            // 打印结果
            System.out.println(name + ":    " + age + ":    " + score);
        }
        // 4. 关闭连接，放回连接池
        conn.close();
    }
}
