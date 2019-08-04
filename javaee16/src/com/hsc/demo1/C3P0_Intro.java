package com.hsc.demo1;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 1.导入jar包`c3p0-0.9.5.2.jar`，`mchange-commons-java-0.2.12.jar`
 * 2.编写`c3p0-config.xml`配置文件，配置对应参数
 * 3.将配置文件放在src目录下
 * 4.创建连接池对象`ComboPooledDataSource`，使用默认配置或命名配置
 */
public class C3P0_Intro {
    public static void main(String[] args) throws SQLException {

        // 使用默认配置创建C3P0连接池: default-config
        ComboPooledDataSource ds = new ComboPooledDataSource();

        // 从连接池获取连接对象，默认配置了10个
        // 先取9个，不放回。
        for (int i = 0; i < 9; i++) {
            Connection conn = ds.getConnection();
            System.out.println("conn = " + conn);
        }

        // 再去最后一个
        Connection conn1 = ds.getConnection();
        System.out.println("conn1 = " + conn1);
        // 将其放回连接池
        conn1.close();
        // 再次将其取出，发现与conn1一样
        Connection conn2 = ds.getConnection();
        System.out.println("conn2 = " + conn2);

        // 使用
        PreparedStatement pstmt = conn2.prepareStatement("insert into student values (null,'凤姐',17,55.8);");
        int result = pstmt.executeUpdate();
        System.out.println("受影响的行数： " + result);
        // 回收连接
        conn2.close();
    }
}
