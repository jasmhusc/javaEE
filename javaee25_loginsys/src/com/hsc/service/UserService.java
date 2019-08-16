package com.hsc.service;

import com.hsc.dao.IUserDao;
import com.hsc.entity.User;
import com.hsc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService {

    /*
     实现用户登录的业务方法：
     直接返回方法的返回值
     */
    public User Login(String username, String password){
        //调用dao根据用户名与密码查询用户并返回
        //1.获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSession();

        //2.获取dao代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        //3.调用方法获取数据
        User user = userDao.findUser(username, password);

        //4.释放资源sqlSession
        MybatisUtils.closeSession(sqlSession);

        //5. 返回数据
        return user;
    }
}
