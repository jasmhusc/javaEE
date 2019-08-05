package com.hsc.mybatis;

public class SqlSessionFactory {
    // 无参构造
    public SqlSessionFactory() {
    }

    // OpenSession方法，获取SqlSession会话
    public SqlSession openSession() {
        return new SqlSession();
    }
}
