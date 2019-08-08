### mybatis1

###### 框架(Framework)

⚫ 整个或者部分系统的可重用设计，是 J2EE 底层技术的封装。框架是可以被应用开发者（程
序员）定制的应用骨架。

###### 开发流程

| mybatis | mybatis 框架快速入门事项                         |
| ------- | ------------------------------------------------ |
| 需求    | 查询全部用户列表。                               |
| 1       | 创建项目                                         |
| 2       | 加入 mybatis 框架 jar 包                         |
| 3       | 准备配置文件：sqlMapConfig.xml，log4j.properties |
| 4       | 编写用户实体类（User）                           |
| 5       | 编写用户 dao 接口（UserMapper）                  |
| 6       | 编写用户 dao 接口映射文件（UserMapper.xml）      |
| 7       | 在 sqlMapConfig.xml 中，加载 UserMapper.xml      |
| 8       | 编写测试代码                                     |

⚫  mybatis 框架包

⚫  mysql 数据库驱动包

⚫  log4j 日志包

⚫ 在 src 准备 sqlMapConfig.xml

```xml
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<environments default="development">
		<environment id="development">
			<transactionManager type="JDBC"/>
			<!--连接池的配置-->
			<dataSource type="POOLED">
				<property name="driver" value="com.mysql.jdbc.Driver"/>
				<property name="url" value="jdbc:mysql://localhost:3306/ 数据库名"/>
				<property name="username" value="root"/>
				<property name="password" value="root"/>
				</dataSource>
		</environment> 
	</environments>
	<!--实体类映射文件的配置-->
	<mappers>
		<mapper resource="com/hsc/dao/UserMapper.xml"/>
	</mappers>
</configuration>
```

⚫ 在 src 下准备 log4j.properties

⚫ 编写用户 UserMapper 接口映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	
<mapper namespace="com.hsc.dao.UserMapper">
	<select id="findAllUsers" resultType="com.hsc.entity.User">
		select * from user
	</select>
</mapper>
```

⚫ 步骤
1.  通过 src 类，加载 sqlMapConfig.xml，得到文件输入流对象
2.  实例化会话工厂创建类 SqlSessionFactoryBuilder
3.  通过会话工厂创建类，读取上面的输入流，得到会话工厂 SqlSessionFactory 类
4.  使用 SqlSessionFactory 对象，创建 SqlSession 对象
a)  它相当于 JDBC 中的 Connection 对象，提供了操作数据库的 CRUD 方法
b)  它提供了一个 getMapper()方法，获取接口的实现对象。
5.  获取接口的对象 UserMapper
6.  执行数据库的查询操作，输出用户信息
7.  关闭会话，释放资源。