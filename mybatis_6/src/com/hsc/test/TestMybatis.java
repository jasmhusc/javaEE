package com.hsc.test;

import com.hsc.dao.UserMapper;
import com.hsc.entity.Condition;
import com.hsc.entity.QueryVo;
import com.hsc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TestMybatis {
    private SqlSession sqlSession;

    @Before
    public void init() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(TestMybatis.class.getResourceAsStream("/sqlMapConfig.xml"));
        sqlSession = factory.openSession();
    }

    @After
    public void release() {
        sqlSession.commit();
        sqlSession.close();
    }

    // 测试通过用户名和性别查询用户
    @Test
    public void testFindUserByUserNameAndSex() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findUserByUserNameAndSex(new QueryVo("", ""));
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    // 测试更新用户信息
    @Test
    public void testUpdateUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(7, "蜘蛛精", Date.valueOf("1995-03-22"), null, null));
        System.out.println("更新了" + i + "条数据");

    }

    // 测试根据id数组删除多个用户
    @Test
    public void testDeleteUsersById() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUsersById(new int[]{7, 9});
        System.out.println("删除了" + i + "条数据");
    }

    // 测试一次性添加多个用户
    @Test
    public void testAddUsers() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = new ArrayList<>();
        users.add(new User(null, "牛魔王", Date.valueOf("1980-01-30"), "男", "火焰山"));
        users.add(new User(null, "红孩儿", Date.valueOf("2009-05-08"), "男", "火云洞"));
        users.add(new User(null, "玉面狐狸", Date.valueOf("2005-11-01"), "女", "狐狸洞"));
        mapper.addUsers(users);
    }

    // 测试Condition
    @Test
    public void testFindUsersByCondition() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Condition condition = new Condition();
        // 设置condition
        condition.setName("精");
        condition.setMinDate(Date.valueOf("1985-01-01"));
        condition.setMaxDate(Date.valueOf("1998-01-01"));
        // 查询
        List<User> users = mapper.findUsersByCondition(condition);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}
