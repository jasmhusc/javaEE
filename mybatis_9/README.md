## mybatis_9

### 注解延迟加载

##### 一对一延迟加载

a)  @Select 编写查询
b)  @Results 配置 1 对 1 关联映射
c)  在@Results 内部使用@Result，指定 column 属性为 id，property，one
d)  one 属性指定为@One 注解，其中 select 属性为方法 findUserInfoById，fetchType 指定为延迟加载类型。

```java
/**
通过 id 查询 1 个用户
*/
@Select("select * from user where id=#{id}")
@Results({
@Result(
column = "id", //user 表中主键 id
property = "userInfo", //对应的用户扩展信息属性
one = @One(
select = "findUserInfoById", //对应的方法名
fetchType = FetchType.LAZY)) //延迟加载
})
User findUserById(int id);
```



##### 一对多延迟加载

1. 在 findUserById()方法修改注解
2. 在@Results 注解中添加@ Result 注解
3. 指定 column 为 user 表中的主键 id，property 对应用户表中的订单集合属性，many 为 @Many 注解
4. @Many 注解中设置 select 为上面的查询方法名，fetchType 为延迟加载。

```java
/**
通过 id 查询 1 个用户
*/
@Select("select * from user where id=#{id}")
@Results({
@Result(
column = "id", //user 表中主键 id
property = "userInfo", //对应的用户扩展信息属性
one = @One(
select = "findUserInfoById", //对应的方法名
fetchType = FetchType.LAZY)
), //延迟加载
@Result(
column = "id", //user 表中的主键
property = "orders", //对应用户表中的订单集合属性
many = @Many(
select = "findOrdersByUid",
fetchType = FetchType.LAZY))
})
User findUserById(int id);
```

##### 