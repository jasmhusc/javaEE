package com.hsc.demo2;

import java.sql.DriverManager;
import java.sql.SQLException;

/*
public class Driver extends NonRegisteringDriver implements java.sql.Driver {
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
    }
}
 */
public class DriverRegister {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*
         注册驱动: 这里会注册两次驱动
          */
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        // 我们只要触发Driver类中的static代码块,里面会注册驱动，不需要：new Driver()
        Class.forName("com.mysql.jdbc.Driver");
    }
}
