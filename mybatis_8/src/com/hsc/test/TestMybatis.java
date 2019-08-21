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
//        System.out.println("user1 = " + user1); 懒加载会失败
        System.out.println(user1.getUsername());
        System.out.println("-------------------");

        /*
         再次查找同样id的user信息，不会再次加载sql语句，会直接从缓存读取。
         Preparing: SELECT * FROM user WHERE id=?; 只有一次
         缓存为一级缓存，生命周期为每一个sqlSession，清空缓存后懒加载失效：
         提交事务：sqlSession.commit();
         清空缓存：sqlSession.clearCache();
          */
//        mapper.deleteUser(1);
//        sqlSession.commit();
//        sqlSession.clearCache();
        User user2 = mapper.findUserById(1);
        System.out.println(user2.getUsername());
        System.out.println("---------------------");

        /*
        测试第二条SQl语句的加载
        Preparing: SELECT * FROM user_info WHERE id=?;
         */
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

    // 测试二级缓存
    @Test
    public void test04() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(TestMybatis.class.getResourceAsStream("/sqlMapConfig.xml"));
        SqlSession sqlSession1 = factory.openSession();

        // 第一个SqlSession
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.findUserById(1);
        sqlSession1.close(); // 需要关闭sqlSqlsession,sqlSession里面的数据才会保存到二级缓存中

        // 第二个SqlSession
        SqlSession sqlSession2 = factory.openSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.findUserById(1);
        sqlSession2.close();
    }
}
