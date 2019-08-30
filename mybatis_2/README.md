### mybatis_2

###### 代理模式

1) 抽象对象，定义了真实对象具有哪些功能，是一个接口或是抽象类。
2) 真实对象，实现了抽象对象中所有的功能
3) 代理对象：对真实对象的一个代理，可以修改真实对象本来的功能，而不用修改真实对象的代码。
4) 调用者，调用真实对象或代理对象。

###### 代理模式的分类

1) 静态代理，必须要重写抽象对象中所有的方法。
2) 动态代理，用得比较多。

- 两者的区别：静态代理，代理对象是自己创建好的一个类。动态代理，代理对象由程序在执行的过程中动态
  生成。

###### 自定义mybatis框架

**UserMapper**: user的dao接口

**User**: 实体类，与表user对应

**Mapper**: 封装接口配置文件 UserMapper.xml 的实体类
				一个 Mapper 对象对应一个 SQL 语句的操作

**Configuration**:解析sqlMapConfig.xml 和UserMapper.xml的内容

 							Configuration 类用于封装 sqlMapConfig.xml 配置内容。
