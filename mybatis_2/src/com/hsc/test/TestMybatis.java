package com.hsc.test;

import com.hsc.dao.UserMapper;
import com.hsc.entity.User;
import com.hsc.mybatis.SqlSession;
import com.hsc.mybatis.SqlSessionFactory;
import com.hsc.mybatis.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试自定义Mybatis
 */
public class TestMybatis {

    @Test
    public void testMybatis() {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 得到会话工厂SqlSessionFactory对象
        InputStream inputStream = TestMybatis.class.getResourceAsStream("/sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(inputStream);

        // 3. 创建SqlSession对象，事务处理。
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. SqlSession获得Mapper的动态代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 5. mapper代理对象执行数据库的查询操作：findAllUsers()
        List<User> list = mapper.findAllUsers();
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }
}
