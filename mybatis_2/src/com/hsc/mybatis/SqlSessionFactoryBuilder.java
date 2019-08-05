package com.hsc.mybatis;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    // 无参构造
    public SqlSessionFactoryBuilder() {
    }

    // Build方法，获取工厂
    public SqlSessionFactory build(InputStream inputStream) {
        return new SqlSessionFactory();
    }

}
