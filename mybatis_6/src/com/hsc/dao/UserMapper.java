package com.hsc.dao;

import com.hsc.entity.Condition;
import com.hsc.entity.QueryVo;
import com.hsc.entity.User;

import java.util.List;


/**
 * User的DAO接口：数据的CRUD操作
 */
public interface UserMapper {

    // 通过用户名和性别查询用户
    List<User> findUserByUserNameAndSex(QueryVo queryVo);

    // 根据ID修改用户的数据
    int updateUser(User user);

    // 根据多个ID删除多个用户
    int deleteUsersById(int[] ids);

    // 一次性添加多个用户到数据库种
    void addUsers(List<User> users);

    /**
     * 通过用户名模糊查询，生日最小值，最大值的区间，三个条件组合查询多个用户。
     */
    List<User> findUsersByCondition(Condition condition);
}
