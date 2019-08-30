package com.hsc.test;


import com.hsc.dao.UserMapper;
import com.hsc.entity.OrderForm;
import com.hsc.entity.Role;
import com.hsc.entity.User;
import com.hsc.entity.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
/*
1. 不要使用断点调试，无法看到懒加载

2. 不要直接输出user对象，因为会触发toString()方法，导致立即加载userInfo对象
 */

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

    // 测试通过id查询用户懒加载用户信息和一级缓存
    @Test
    public void test01() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 先查找id为1的user基本信息，只会加载一条语句。
        User user1 = mapper.findUserById(1);
        System.out.println(user1.getUsername());
        System.out.println("-------------------");

        User user2 = mapper.findUserById(1);
        System.out.println(user2.getUsername());
        System.out.println("---------------------");

        UserInfo userInfo = user2.getUserInfo();
        System.out.println("userInfo = " + userInfo);
    }

    // 测试通过id查询用户懒加载用户订单
    @Test
    public void test02() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(2);
        // 先输出用户基本信息
        System.out.println("姓名： " + user.getUsername() + "生日：   " + user.getBirthday());
        System.out.println("----------------");

        // 再获取用户订单信息
        List<OrderForm> orders = user.getOrders();
        for (OrderForm order : orders) {
            System.out.println("order = " + order);
        }
    }

    // 测试通过uid查询用户的角色roles
    @Test
    public void test03() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(2);
        // 先输出用户基本信息
        System.out.println("姓名： " + user.getUsername() + "，生日： " + user.getBirthday());
        System.out.println("----------------");

        // 再获取用户订单信息
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            System.out.println("role = " + role);
        }
    }
}
