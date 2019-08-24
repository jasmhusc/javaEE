package com.hsc.service;

import com.hsc.dao.IUser;
import com.hsc.entity.User;
import com.hsc.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    // 根据用户名和密码登录，返回该用户所有信息。
    public User login(String name, String pwd) {
        SqlSession session = MybatisUtils.getSession();
        IUser userDao = session.getMapper(IUser.class);
        User user = userDao.findUser(name, pwd);
        MybatisUtils.closeSession(session);
        return user;
    }
}
