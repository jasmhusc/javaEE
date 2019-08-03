## DDL操作数据库

### 创建数据库

- 直接创建数据库db1
`CREATE DATABASE db1;`

- 判断是否存在并创建数据库db2
`CREATE DATABASE IF NOT EXISTS db2;`

- 创建数据库db3并指定字符集为gbk
`CREATE DATABASE db3 DEFAULT CHARACTER SET gbk;`

### 查看数据库
- 查看所有的数据库
`SHOW DATABASES;`

- 查看某个数据库的定义信息
`SHOW CREATE DATABASE db3;`


### 修改数据库
- 将db3数据库的字符集改成utf8
`ALTER DATABASE db3 DEFAULT CHARACTER SET utf8;`

- 删除db2数据库
`DROP DATABASE db2;`

- 查看正在使用的数据库
SELECT DATABASE();

- 切换数据库
`USE db1;`


## DDL操作表
- 创建student表包含id,name,birthday字段
`CREATE TABLE student(
	id INT,
	NAME VARCHAR(20),
	birthday DATE
);`

### 查看表:show,desc

- 查看mysql数据库中的所有表
`SHOW TABLES;`

- 查看student表的结构
`DESC student;`

- 查看student的创建表SQL语句
`SHOW CREATE TABLE student;`

### 修改表：create,drop,alter,
- 创建s1表，s1表结构和student表结构相同
`CREATE TABLE s1 LIKE student;`

- 直接删除表s1表
`DROP TABLE s1;`

- 判断表是否存在并删除s1表
`DROP TABLE IF EXISTS s1;`


- 为学生表添加一个新的字段remark,类型为varchar(20)
`ALTER TABLE student ADD remark VARCHAR(20);`


- 将student表中的remark字段的改成varchar(100)
`ALTER TABLE student MODIFY remark VARCHAR(100);`

- 将student表中的remark字段名改成intro，类型varchar(30)
`ALTER TABLE student CHANGE remark intro VARCHAR(30);`

- 删除student表中的字段intro
`ALTER TABLE student DROP intro;`

- 将学生表student改名成student2
`RENAME TABLE student TO student2;`

- 将sutden2表的编码修改成gbk
`ALTER TABLE student2 DEFAULT CHARACTER SET gbk;`
