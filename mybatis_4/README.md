## mybatis_4
1. **传统的DAO实现类的开发方式**
2. **一般步骤**：
- 编写UserMapper接口

- 编写UserMapper接口映射文件:UserMapper.xml

- 编写接口实现类UserMapperImpl，实现UserMapper接口

- 编写测试类:TestMybatis

3. **API**
```java
// 查询
sqlSession.selectOne("com.hsc.dao.UserMapper.findUserById", id);
// 插入
sqlSession.insert("com.hsc.dao.UserMapper.addUser", user);

```

