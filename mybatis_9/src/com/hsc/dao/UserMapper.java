package com.hsc.dao;

import com.hsc.entity.OrderForm;
import com.hsc.entity.Role;
import com.hsc.entity.User;
import com.hsc.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {

    // 1. 通过id查询用户
    @Select("SELECT * FROM user WHERE id=#{uid};")
    @Results({ // 对结果集进行映射
            // 注解配置关联关系，只需要配置主键，其他字段会自动映射
            @Result(property = "id" ,column = "id",id = true), // 主键映射
            @Result(property = "userInfo",column = "id",javaType = UserInfo.class,
                    // select表示要查询的方法名 fetchType指定为LAZY表示延迟加载
            one = @One(select = "findUserInfoById",fetchType = FetchType.LAZY)),
            @Result(property = "orders",column = "id",javaType = List.class,
            many = @Many(select = "findOrdersByUID",fetchType = FetchType.LAZY)),
            @Result(property = "roles",column = "id",javaType = List.class,
            many = @Many(select = "findRolesByUserId",fetchType = FetchType.LAZY))
    })
    User findUserById(int uid);

    // 2. 通过id查询用户扩展信息，一对一
    @Select("SELECT * FROM user_info WHERE id=#{id};")
    UserInfo findUserInfoById(int uid);

    // 3. 通过用户id查询用户的所有订单，一对多
    @Select("SELECT * FROM order_form WHERE user_id=#{id};")
    List<OrderForm> findOrdersByUID(int uid);

    // 4. 通过用户id查询用户所有role，一对多
    @Select("SELECT * FROM role r INNER JOIN user_role ur ON r.role_id=ur.role_id WHERE ur.user_id=#{userId};")
    List<Role> findRolesByUserId(int userId);

    // 编写一个删除的方法，目的是测一级缓存的清空
    void deleteUser(int uid);
}
