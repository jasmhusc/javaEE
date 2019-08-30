package com.hsc.test;

import com.hsc.dao.UserMapper;
import com.hsc.entity.Configuration;
import com.hsc.entity.User;
import com.hsc.mybatis.SqlSession;
import com.hsc.mybatis.SqlSessionFactory;
import com.hsc.mybatis.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserMapper {
    private static SqlSessionFactory factory;
    private SqlSession sqlSession;

    // 创建工厂对象
    @BeforeClass
    public static void init() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream in = TestUserMapper.class.getResourceAsStream("/sqlMapConfig.xml");
        factory = builder.build(in);
    }

    // 创建会话对象，自动提交事务
    @Before
    public void begin() {
        sqlSession = factory.openSession();
    }

    // 测试 Configuration
    @Test
    public void testConfiguration(){
        Configuration configuration = new Configuration();
        System.out.println("configuration = " + configuration);
    }

    // 测试会话类
    @Test
    public void testSqlSession(){
        SqlSession session = new SqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.findAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserById() {
        //得到接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    //关闭会话
    @After
    public void end() {
        // sqlSession.close();
    }
}
