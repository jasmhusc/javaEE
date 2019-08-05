package com.hsc.dao;

import com.hsc.entity.User;

import java.util.List;

/**
 * User的DAO接口：数据的CRUD操作
 */
public interface UserMapper {
    /**
     * 根据id查询用户
     */
    User findUserById(Integer id);

    /**
     * 查询所有用户
     */
    List<User> findAllUsers();
}
