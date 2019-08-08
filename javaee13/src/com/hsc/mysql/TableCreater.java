package com.hsc.mysql;

import com.hsc.annotation.Constraints;
import com.hsc.annotation.DBTable;
import com.hsc.annotation.SQLInteger;
import com.hsc.annotation.SQLString;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * 创建mysql数据库table的工具类：
 * 包含自动生成创表语句的静态方法，参数为类名。
 */
public class TableCreater {

    // 生成表格创建的SQL语句
    public static String createTableSql(String className) throws ClassNotFoundException {
        // 1. 通过calssName获取类的Class对象
        Class<?> cls = Class.forName(className);
        // 2. 判断类上是否有创表注解（创表的标志）
        if (!cls.isAnnotationPresent(DBTable.class)) {
            System.out.println("No DBTable annotations in class " + className);
            return null;
        }
        DBTable dbTable = cls.getAnnotation(DBTable.class);
        String tableName = dbTable.name();
        // 3. 判断表名是否为默认值："" 空字符串
        if (tableName.length() < 1) {
            tableName = cls.getName().toUpperCase();
        }
        // 新建一个String类型的List，存放每一行的SQL语句
        ArrayList<String> columnDefs = new ArrayList<>();

        // 4. 继续获取字段上的注解
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            String columnName = null;

            // 判断字段上是否有注解
            if (field.getAnnotations().length < 1) {
                continue;
            }
            // 取出我们需要的注解
            if (field.isAnnotationPresent(SQLString.class)) {
                SQLString sqlString = field.getAnnotation(SQLString.class);
                String name = sqlString.name();
                // 字段名称
                columnName = name;
                if (columnName.length() < 1)
                    columnName = field.getName().toUpperCase();
                // 字段类型
                columnDefs.add(columnName + " VARCHAR(" +
                        sqlString.value() + ")" +
                        getConstraints(sqlString.constraint()));
            }
            if (field.isAnnotationPresent(SQLInteger.class)) {
                SQLInteger sqlInteger = field.getAnnotation(SQLInteger.class);
                String name = sqlInteger.name();
                // 字段名称
                columnName = name;
                if (columnName.length() < 1)
                    columnName = field.getName().toUpperCase();
                // 字段类型
                columnDefs.add(columnName + " INT" +
                        getConstraints(sqlInteger.constraint()));
            }
        }
        StringBuilder createCommand = new StringBuilder(
                "CREATE TABLE " + tableName + "(");
        for (String columnDef : columnDefs)
            createCommand.append("\n    " + columnDef + ",");
        String tableCreate = createCommand.substring(
                0, createCommand.length() - 1) + ");";
        return tableCreate;
    }

    private static String getConstraints(Constraints con) {

        String constraints = "";
        if (con.notNull())
            constraints += " NOT NULL";
        if (con.primaryKey())
            constraints += " PRIMARY KEY";
        if (con.unique())
            constraints += " UNIQUE";
        if (con.autoIncrement())
            constraints += " AUTO_INCREMENT";

        return constraints;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String[] arg = {"com.hsc.bean.Member"};
        for (String className : arg) {
            System.out.println("Table Creation SQL for " +
                    className + " is :\n" + createTableSql(className));
        }
    }
}
