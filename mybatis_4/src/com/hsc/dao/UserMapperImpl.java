package com.hsc.dao;

import com.hsc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 接口的实现类
 */
public class UserMapperImpl implements UserMapper {
    private static SqlSession sqlSession;

    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(UserMapperImpl.class.getResourceAsStream("/sqlMapConfig.xml"));
        sqlSession = factory.openSession();
    }

    @Override
    public User findUserById(int id) {
        User user = sqlSession.selectOne("com.hsc.dao.UserMapper.findUserById", id);
        return user;
    }

    @Override
    public int addUser(User user) {
        int insert = sqlSession.insert("com.hsc.dao.UserMapper.addUser", user);
        sqlSession.commit();
        sqlSession.close();
        return insert;
    }
}
