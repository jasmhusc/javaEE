package com.hsc.mysql;

import com.hsc.annotation.DBTable;

import java.lang.reflect.Field;

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
        if (cls.isAnnotationPresent(DBTable.class))
            return null;
        DBTable dbTable = cls.getAnnotation(DBTable.class);
        String dbName = dbTable.name();

        // 3. 继续获取字段上的注解
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            // 判断字段上是否有注解

        }
        return null;
    }
}
