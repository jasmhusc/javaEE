package com.hsc.dao;

import com.hsc.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    /**
     * 查询以指定名字开头的所有用户
     */
    @Select("SELECT * FROM user WHERE name LIKE #{name} limit 0,8")
    List<User> findAllByName(String name);
}
