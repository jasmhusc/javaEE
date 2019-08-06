package com.hsc.dao;

import com.hsc.entity.QueryVo;
import com.hsc.entity.User;

import java.util.List;

/**
 * User的DAO接口：数据的CRUD操作
 */
public interface UserMapper {
    /**
     * 根据id查询用户
     */
    User findUserById(int id);

    /**
     * 查询所有用户
     */
    List<User> findAllUsers();

    /**
     * 根据id查询用户
     */
    List<User> findUserByIdRM(int id);

    /**
     * 添加用户
     */
    void addUser(User user);

    /**
     * 根据ID修改用户
     */
    void updateUser(User user);

    /**
     * 根据ID删除用户
     */
    void deleteUser(int id);

    /**
     * 根据名称模糊查询
     */
    List<User> findUserLikeUserName(String name);

    /**
     * 查询出生日期在一定范围
     */
    List<User> findUserByBirthday(String start, String end);

    /**
     * 查询出生日期在一定范围，pojo版
     */
    List<User> findUserByBirthdayPro(QueryVo queryVo);

    /**
     * 查询某种性别的数量
     */
    int getCountBySex(String gender);
}
