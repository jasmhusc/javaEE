package com.hsc.demo10;

import com.hsc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ParameterMetaData: 参数元数据
 */
public class ParameterMeteData {
    public static void main(String[] args) throws SQLException {

        // 获取PreparedStatement`对象
        String sql = "INSERT INTO employee (name, age, address) VALUES (?, ?, ?);";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 1. 获取`ParameterMetaData`对象
        ParameterMetaData pmd = pstmt.getParameterMetaData();

        // 2. 获取参数的个数：即sql语句里?的个数
        int count = pmd.getParameterCount();
        System.out.println("count = " + count);

        // 3. 获取参数类型和名称 获取失败
        /*for (int i = 1; i <= count; i++) {
            int j = pmd.getParameterType(i);
            String typeName = pmd.getParameterTypeName(i);
            String className = pmd.getParameterClassName(i);

            System.out.println("type = "+j+"    typeName = " + typeName+"   className = " + className);
        }*/
    }
}
