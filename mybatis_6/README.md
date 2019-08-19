## mybatis_6

### 动态SQL
- 动态SQL
```
在程序运行时，根据传入的参数情况，拼接最终执行的sql语句。
```

| 1）if           | <if test="username!=null and username!=''"><br/>user_name like '%${username}%'<br/></if> |
| --------------- | ------------------------------------------------------------ |
| **2)  where**   | **智能的去掉多余的 and、or 、where关键字**                   |
| **3)  set**     |                                                              |
| **4)  foreach** | **循环处理参数集合（list、数组）**<br/>foreach：循环处理参数集合<br/>collection：参数集合，是 **list**<br/>item：当前遍历的对象变量名<br/>separator：指定分割符<br/>#{}中使用变量名引用每个属性名<br/>循环体最后不用加逗号<br/><foreach collection="list" item="user" separator=","><br/>(#{user.username},#{user.birthday},#{user.sex},#{user.address})<br/></foreach> |
| **5) foreach**  | <br/>foreach：循环处理数组，说明：<br/>collection：参数集合，这里是数组 **array**<br/>open：拼装的 sql 语句片段的开始部分<br/>close：拼装的 sql 语句片段的结束部分<br/>item：当前遍历元素的变量名<br/><br/><foreach collection="array" item="id" open="(" <br/>separator="," close=")"><br/>#{id}<br/></foreach> |
| **6)  sql**     | **sql 标签：定义公共的 sql 语句片段**                        |
| **7)  include** | **include 标签：引用上面定义的 sql 标签**                    |

- 案例需求：

```java
  通过用户名模糊查询，生日最小值，最大值的区间，三个条件组合查询多个用户。
```
- 案例实现步骤
```
1. 使用 Condition(pojo) 封装上面的三个条件：name, minDate,maxDate
2. 在 IUserDao.xml 中使用 sql 标签定义查询条件代码块
3. 在查询方法中，使用 include 引用上面的条件代码块
4. 查询符合条件的用户信息，返回 List<User>
```
