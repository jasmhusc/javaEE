package com.hsc.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SourceCloseUtils {
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
