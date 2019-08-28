package com.hsc.service;

import com.hsc.dao.IUserDao;
import com.hsc.entity.User;
import com.hsc.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {

    // 根据名称查询用户
    public List<User> findUsersByName(String name) {
        // 查询用户
        SqlSession sqlSession = MybatisUtils.getSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> userList = userDao.findAllByName(name + "%");
        MybatisUtils.closeSession(sqlSession);
        return userList;
    }
}
