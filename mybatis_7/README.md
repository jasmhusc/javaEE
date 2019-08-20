## mybatis_7

### 多表查询

1. 一对一查询
   - 在 User 类中创建 UserInfo，后者作为一个成员变量，创建一对一的关系。
   
   - UserMapper接口中同时查询两个表格的信息，提供：User findUserAndInfo(int uid);
   
   - 查询语句SQL依然用内链接方式查询。
   
   -  association 定义一对一关联映射
   
     ```xml
     <!--
     association：配置一对一关联关系，说明：
     property：要映射的属性名称
     javaType：要映射的属性类型（可以指定，可以不指定，建议都指定）
     -->
     ```
   
     
   
2. 一对多查询

   - 创建多方的javabean类，属性驼峰命名

   - 在一方添加该类型的集合，List<T> 属性名称

   - UserMapper接口添加相应的方法，List<T> fun(T t);

   - collection：配置一对多关联关系，指定 property，javaType(可选)，ofType，resultMap 为 orderMap

     ```xml
     <resultMap id="userOrdersMap" type="User" extend="userMap">
     <!--
     collection：配置一对多关联关系，说明：
     property：要映射的属性名称
     javaType：要映射的属性类型（可以指定，可以不指定，建议都指定）
     ofType：指定集合中存放的类型（必须要指定）
     -->
     <collection property="orders" javaType="list" ofType="OrderForm" resultMap="orderMap"/>
     </resultMap>
     ```

     
