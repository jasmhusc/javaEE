package com.hsc.demo10;

import com.hsc.util.JDBCUtil;

import java.sql.*;

/**
 * “元数据”，定义数据的数据，指的是数据库中 库、 表、 列 的定义信息。
 * ResultSetMetaData: 结果集元数据,包含了字段(列)的数量, 字段的名称, 字段的类型
 */
public class MetaData {
    public static void main(String[] args) throws SQLException {

        // 获取结果集
        String sql = "SELECT * FROM employee;";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        // 获取结果集元数据
        ResultSetMetaData rsMetaData = rs.getMetaData();
        // 1. 得到列的数量
        int count = rsMetaData.getColumnCount();
        System.out.println("count = " + count);
        // 2. 得到列的类型
        for (int i = 1; i <= count; i++) {
            String typeName = rsMetaData.getColumnTypeName(i);
            System.out.println("typeName = " + typeName);
        }
        // 3. 得到列的名称
        for (int i = 1; i <= count; i++) {
            String columnName = rsMetaData.getColumnName(i);
            System.out.println("columnName = " + columnName);
        }
    }
}
