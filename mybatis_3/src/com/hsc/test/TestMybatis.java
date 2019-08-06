package com.hsc.test;

import com.hsc.dao.UserMapper;
import com.hsc.entity.QueryVo;
import com.hsc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class TestMybatis {
    private SqlSession sqlSession;

    @Before
    public void init() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(TestMybatis.class.getResourceAsStream("/sqlMapConfig.xml"));
        sqlSession = factory.openSession();
    }

    @Test
    public void testFindUserById() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(6);
        System.out.println("user = " + user);
    }

    @Test
    public void testFindAllUsers() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findAllUsers();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testFindUserByIdRM() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findUserByIdRM(2);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testAddUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(null, "凤姐", Date.valueOf("1980-08-27"), "妖", "中国"));
    }

    @Test
    public void testUpdateUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5, "白龙马", Date.valueOf("1530-08-27"), "仙", "西海龙宫"));
    }

    @Test
    public void testDeleteUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(6);
    }

    @Test
    public void testFindUserLikeUserName() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findUserLikeUserName("%精%");
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testFindUserByBirthday() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findUserByBirthday("1990-01-01", "2000-01-01");
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testFindUserByBirthdayPro() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo(null, "1400-01-01", "1990-01-01");
        List<User> users = mapper.findUserByBirthdayPro(queryVo);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testgetCountBySex() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.getCountBySex("女");
        System.out.println("性别为女的数量：" + count);
    }

    @After
    public void release() {
        sqlSession.commit();
        sqlSession.close();
    }
}
