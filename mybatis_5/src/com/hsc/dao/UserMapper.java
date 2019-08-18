package com.hsc.dao;

import com.hsc.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    //  通过id查询到一个用户
    @Select("SELECT * FROM user WHERE id=#{id};")
    User findUserById(int id);

    // 使用注解对结果进行映射
    // Results里面传Result类型的数组，{}
    @Select("SELECT id id2, username username2, birthday birthday2, sex, address FROM user WHERE id = #{id};")
    @Results({
            @Result(column = "id2", property = "id", id = true), // 对主键进行映射
            @Result(column = "username2", property = "username"), // 对普通字段进行映射
            @Result(column = "birthday2", property = "birthday")
    })
    User findUserByIdRM(int id);

    // 根据用户id修改用户
    @Update("UPDATE user SET username=#{username}, birthday=#{birthday}, sex=#{sex}, address=#{address} WHERE id=#{id};")
    void updateUser(User user);

    // 根据用户id删除用户
    @Delete("DELETE FROM user WHERE id=#{id};")
    void deleteUserById(int id);

    // 添加user
    @Insert("INSERT INTO user VALUES(NULL, #{username}, #{birthday}, #{sex}, #{address});")
    @SelectKey(statement = "SELECT LAST_INSERT_ID();", keyColumn = "id", keyProperty = "id", before = false, resultType = int.class)
    int addUser(User user);
}
