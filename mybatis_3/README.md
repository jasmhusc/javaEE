## mybatis_3

### 自定义Mybatis框架（查询）

##### Properties

```xml
<!--
    加载属性资源文件，说明：
    1.resource：加载【本地】属性资源文件
    2.url：加载【网络上】属性资源文件（url="http://127.0.0.1:8080/db.properties"）
    3.使用内部 property 标签定义属性，首先加载内部 property 标签定义属性，再加载属性资源文件中的属性。
    如果有相同的属性，外部资源文件中的属性会覆盖内部 property 标签定义的属性。
-->
<properties resource="db.properties">
	<property name="username" value="root"/>
	<property name="password" value="root"/>
</properties>
```

##### typeAliases

```xml
<!-- 配置自定义别名 -->
<typeAliases>
<!--
    配置用户别名，说明：
    1.type：指定为哪个类定义别名
    2.如果没有设置 alias 属性：默认使用类的名称作为别名
    3.alias：指定别名
-->
	<typeAlias type="com.hsc.entity.User" alias="user"/>
    
    <!--
包扫描方式配置自定义别名，说明：
    1.name：指定要扫描的包
    2.默认都是使用类名作为别名
    3.如果有多个包，在同一个父包下，配置父包即可。
    4.可以使用多个 package 元素配置多个不同的包
-->
	<package name="com.hsc.entity"/>
</typeAliases>
```

##### mappers

```xml
<!--加载 mapper 映射文件 -->
<mappers>
	<!--加载用户接口映射文件-->
	<mapper resource="com/hsc/dao/UserMapper.xml"/>
	<!--加载订单接口映射文件-->
	<mapper resource="com/hsc/dao/OrderMapper.xml"/>
</mappers>
```



```xml
<mappers>
<!--
    包扫描方式加载 mapper 映射文件,说明：
    1.要求 mapper 映射文件，与 mapper 接口要放在同一个目录
    2.要求 mapper 映射文件的名称，与 mapper 接口的名称要一致
-->
	<package name="com.hsc.dao"/>
</mappers>
```

##### SELECT

```xml
<!--
    select 标签：放置查询 sql 语句
    id：唯一标识名称，与接口方法名称一致
    parameterType：输入参数类型，与接口方法形参类型一致
    resultType：返回值类型，与接口方法返回值类型一致
    #{id}：占位符，相当于 jdbc 中的问号,变量名随意
-->
<select id="findUserById" parameterType="java.lang.Integer"
	resultType="com.hsc.entity.User">
	select * from `user` where id=#{id}
</select>
```

##### INSERT

```xml
<!--
	新增用户,insert 标签：放置新增 sql 语句
-->
<insert id="addUser" parameterType="User">
	INSERT INTO user VALUES (null,#{username},#{birthday},#{sex},#{address});
</insert>

```

```xml
<insert id="addUser" parameterType="User">
	
	<selectKey keyColumn="id" keyProperty="id" order="AFTER" resultType="int">
	select last_insert_id()
	</selectKey>
    insert into "user" (id,username,birthday,sex,address)
    values(#{id},#{username},#{birthday},#{sex},#{address}) 
</insert>
```

```xml
<!--
    useGeneratedKeys: 使用生成的主键
    keyColumn：表中主键对应的列
    keyProperty：实体类中主键的属性
-->
<insert id="addUser" parameterType="User" useGeneratedKeys="true" keyProperty="id"
keyColumn="id">
	INSERT INTO user VALUES (null,#{username},#{birthday},#{sex},#{address})
</insert>
```

**UPDATE**

```xml
<!--
	根据用户 id 修改用户，说明：
	update 标签：放置修改 sql 语句
-->
<update id="updateUser" parameterType="User">
	update `user` set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address}
	where id=#{id}
</update>
```



**DELETE**

```xml
<!--
	根据用户 Id 删除用户，说明：
	delete 标签：放置删除 sql 语句
-->
<delete id="deleteUser" parameterType="int">
	delete from `user` where id=#{id}
</delete>
```
**resultType**
```xml
<!--使用 resultType 完成输出映射，要求 sql 语句中字段（列）的名称，与 java 对象中的属性名称一
致。否则不能完成映射。
1) 使用 as 给 user_name 定义别名为 username，从而与属性名一致。
2) 使用 resultMap 进行映射
-->
<select id="findUserById" parameterType="int" resultType="User">
<!-- 定义 user_name 列的别名为 username -->
select id, user_name as username, birthday,sex,address from `user` where id=#{id}
</select>

<settings>
<setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
```


