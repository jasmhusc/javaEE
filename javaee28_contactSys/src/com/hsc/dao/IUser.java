package com.hsc.dao;

import com.hsc.entity.Rank;
import com.hsc.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

// 登录用户信息表
public interface IUser {

    // 查询用户
    @Select("SELECT * FROM user WHERE username=#{username} AND password=#{password}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "rank_id", property = "rank",
                    one = @One(select = "findRankInfo", fetchType = FetchType.LAZY))
    })
    User findUser(@Param("username") String username, @Param("password") String password);

    // 根据id查询用户等级信息
    @Select("SELECT * FROM rank WHERE id=#{id}")
    Rank findRankInfo(int id);
}
