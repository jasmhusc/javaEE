package com.hsc.dao;

import com.hsc.entity.Role;
import com.hsc.entity.User;

/**
 * User的DAO接口：数据的CRUD操作
 */
public interface UserMapper {

    /*
    一对一查询：
     查询用户及用户的扩展信息
      */
    User findUserAndUserInfo(int uid);

    /*
    一对多查询
     查询用户及用户的所有订单
      */
    User findUserAndOrders(int uid);

    /*
    一对多查询
     查询用户及用户的所有角色
      */
    User findUserAndRoles(int uid);

    /*
    多对多查询
     查询角色及角色对应的所有用户
      */
    Role findRoleAndUsers(int rid);
}
