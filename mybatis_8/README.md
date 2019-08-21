## mybatis_8

### lazyload 延迟加载



1. 延迟加载概念：也叫**懒加载**。指的是**按需加载**，在实际用到数据的时候才加载。
2. 延迟加载特点：先从一张表中查询，需要时再从关联表中查询数据。因为都是**单表**的操作，对于提升数据库性
   能有一定的帮助。
3. 使用延迟加载：都是在多表**关联查询**的场景中。MyBatis 框架提供的一对一关联查询配置（association）标签，
   一对多关联查询配置（collection）标签，支持延迟加载。

- 配置步骤
  1. 配置 association 的 1 对 1 关联查询

  2. 关联属性再发送一条 SQL 语句去查询从表中的数据，其中 **column** 指定主表的主键列，**select** 指定要查询的
      SQL 语句。

    ```xml
    <!--
    使用延迟加载方式实现:
    配置三个参数即可：
    property: 对应的属性名
    select：配置要调用的查询 sql 语句 id（名称空间+"."+sql 语句 id）。
    column：配置要传递的参数字段，这里是 User 表中的主键
    -->
    ```

    

  3. 开启延迟加载的 settings：
     ⚫  lazyLoadingEnabled：开启延迟加载开关，默认是 false 未开启，需要配置为 true
     ⚫  aggressiveLazyLoading：将积极加载改为 false 消极加载，即不使用积极加载，默认为 false

     ```xml
     <settings>
     <!--开启延迟加载-->
     <setting name="lazyLoadingEnabled" value="true"/>
     <!--不使用积极加载-->
     <setting name="aggressiveLazyLoading" value="false"/>
     </settings>
     ```

     

     
     