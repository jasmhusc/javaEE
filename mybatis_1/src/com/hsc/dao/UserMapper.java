package com.hsc.dao;

import com.hsc.entity.User;

import java.util.List;

/**
 * User类的DAO接口
 */
public interface UserMapper {
    List<User> findAllUsers();
}
