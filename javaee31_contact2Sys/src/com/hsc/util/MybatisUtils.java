package com.hsc.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

// 工具类
public class MybatisUtils {
    private static SqlSessionFactory factory = null;

    static {
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
            factory = builder.build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return factory.openSession();
    }

    public static SqlSession getSession(boolean isAutoCommit) {
        return factory.openSession(isAutoCommit);
    }

    public static void closeSession(SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
    }
}
