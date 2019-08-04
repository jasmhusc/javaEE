package com.hsc.lodin.service;

import com.hsc.lodin.dao.UserDao;
import com.hsc.lodin.dao.UserDaoImpl;

import java.sql.SQLException;

/*
业务层,负责业务逻辑的处理
 */
public class UserService {

    // 登录业务逻辑
    public boolean Loadin(String username, String password) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        Boolean query = userDao.query(username, password);
        return query;
    }
}
