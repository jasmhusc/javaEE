package com.hsc.test;

import com.hsc.dao.UserMapper;
import com.hsc.entity.OrderForm;
import com.hsc.entity.Role;
import com.hsc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testfindUserAndUserInfo() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserAndUserInfo(1);
        System.out.println("user = " + user);
    }

    @Test
    public void findUserAndOrders() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserAndOrders(2);
        System.out.println("user = " + user);
        // 输出user中的订单集合
        List<OrderForm> orders = user.getOrders();
        for (OrderForm order : orders) {
            System.out.println("order = " + order);
        }
    }

    @Test
    public void findUserAndRoles() {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserAndRoles(1);
        System.out.println("user = " + user);
        // 输出user对象里的roles集合
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            System.out.println("role = " + role);
        }
    }

    @Test
    public void findRoleAndUsers() {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Role role = mapper.findRoleAndUsers(3); // 班主任
        System.out.println("role = " + role);
        // 输出role里的所有user
        List<User> users = role.getUsers();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

}

