package com.hsc.dao;

import com.hsc.entity.User;

public interface UserMapper {
    //  通过id查询到一个用户
    User findUserById(int id);

    // 添加user
    int addUser(User user);
}
