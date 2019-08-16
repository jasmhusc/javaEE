package com.hsc.dao;

import com.hsc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/*
    数据库的user表对应的dao接口
 */
public interface IUserDao {

    // 根据用户名和密码查找用户
    //@Param 给参数起别名，之后在sql语句中使用别名，一般这个注解应用在多个参数的时候
    @Select("SELECT * FROM user WHERE username=#{username} and password=#{password};")
    User findUser(@Param("username") String username, @Param("password") String password);
}
