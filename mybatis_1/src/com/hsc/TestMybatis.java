package com.hsc;

import com.hsc.dao.UserMapper;
import com.hsc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    // 测试Mybatis
    @Test
    public void testMybatis() {
        // 1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

        // 2.得到会话工厂SqlSessionFactory类
        InputStream is = TestMybatis.class.getResourceAsStream("/sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(is);

        // 3.创建SqlSession对象, 相当于数据库连接
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4.通过SqlSession对象得到Mapper接口的代理对象
        // mapper: 接口的实现类对象,通过动态代理生成的
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 5.Mapper接口的代理对象执行数据库的查询操作
        List<User> list = mapper.findAllUsers();
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }
}
