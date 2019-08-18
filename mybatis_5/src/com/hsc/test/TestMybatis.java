package com.hsc.test;

import com.hsc.dao.UserMapper;
import com.hsc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class TestMybatis {

    SqlSession sqlSession;

    @Before
    public void init() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(TestMybatis.class.getResourceAsStream("/sqlMapConfig.xml"));
        sqlSession = factory.openSession();
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    // 根据用户id查询用户
    @Test
    public void test01() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(3);
        System.out.println("user = " + user);
    }

    // 使用注解对结果进行映射
    @Test
    public void test02() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserByIdRM(3);
        System.out.println("user = " + user);
    }

    // 根据用户id修改用户
    @Test
    public void test03() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "苍老师", Date.valueOf("1990-09-09"), "男", "岛国");
        mapper.updateUser(user);
    }

    // 根据用户id删除用户
    @Test
    public void test04() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(8);
    }

    // 新增用户
    @Test
    public void test05() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "波多老师", Date.valueOf("1999-09-09"), "女", "东京");
        mapper.addUser(user);
        System.out.println("添加后: " + user);
    }
}
