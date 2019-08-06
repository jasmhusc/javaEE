package com.hsc.test;

import com.hsc.dao.UserMapper;
import com.hsc.dao.UserMapperImpl;
import com.hsc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class TestMybatis {

    @Test
    public void testFindUserById() {
        UserMapperImpl dao = new UserMapperImpl();
        User user = dao.findUserById(2);
        System.out.println("user = " + user);
    }

    @Test
    public void testAddUser() {
        UserMapperImpl dao = new UserMapperImpl();
        User u = new User(10, "小王", Date.valueOf("2022-02-02"), "男", "深圳");
        dao.addUser(u);
    }

}
