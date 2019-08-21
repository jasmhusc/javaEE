package com.hsc.dao;

import com.hsc.entity.OrderForm;
import com.hsc.entity.Role;
import com.hsc.entity.User;
import com.hsc.entity.UserInfo;

import java.util.List;

public interface UserMapper {
    /**
     * 直接一对一查询用户信息和扩展信息，会显示所有信息，有时可能不希望一次性
     * 查找出来，希望扩展信息在需要时才加载，可以拆成两步查询，采用懒加载，
     * 两个表之间将id进行传递共享，实现连接。
     */
    // 1. 通过id查询用户
    User findUserById(int uid);

    // 2. 通过id查询用户扩展信息
    UserInfo findUserInfoById(int uid);

    // 3. 通过用户id查询用户的所有订单
    List<OrderForm> findOrdersByUID(int uid);

    // 4. 通过用户id查询用户所有role
    List<Role> findRolesByUserId(int userId);

    // 编写一个删除的方法，目的是测一级缓存的清空
    void deleteUser(int uid);
}
