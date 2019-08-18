## mybatis_5

### Annotation注解开发

1. 编写UserMapper接口，在方法上配置注解

| annotation               | 作用                                       |
| ------------------------ | ------------------------------------------ |
| @Select(SQL查询语句)     | 查询，内部直接写SELECT...FROM...语句       |
| @Results（{@Result...}） | 映射集，放置@Result注解。                  |
| @Result                  | 映射，先对主键进行映射，再对普通字段映射。 |
| @Update                  | 更新，写UPDATE ... SET语句                 |
| @Insert                  | 插入，写INSERT INTO...语句                 |
| @Delete                  | 删除，写DELETE FROM...语句                 |
| @SelectKey               | 查询数据库维护的主键值，获取主键的值       |

 - 主键必须映射
 - 表中的字段与java类中的属性相同，可以省略映射@Result

3. 编写测试类：TestMybatis
