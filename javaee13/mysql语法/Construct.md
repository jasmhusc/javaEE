-- 创建表学生表st5, 包含字段(id, name, age)将id做为主键
-- 创建表时添加主键: 字段名 字段类型 PRIMARY KEY
```
CREATE TABLE st5(
	id INT PRIMARY KEY,
	NAME VARCHAR(20),
	age INT
);


INSERT INTO st5 (id, NAME) VALUES (1, '唐伯虎');
INSERT INTO st5 (id, NAME) VALUES (2, '周文宾');
INSERT INTO st5 (id, NAME) VALUES (3, '祝枝山');
```
-- 添加有问题的数据:
``` 
INSERT INTO st5 (id, NAME) VALUES (1, '文征明');
INSERT INTO st5 (id, NAME) VALUES (NULL, '文征明');
```

-- 删除主键
```
ALTER TABLE st5 DROP PRIMARY KEY;
```

-- 在已有表中添加主键
```
ALTER TABLE st5 ADD PRIMARY KEY(id);
```

-- 主键自动增长
-- 创建学生表st6, 包含字段(id, name, age)将id做为主键并自动增长
```
CREATE TABLE st6(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT
);
```

-- 主键默认从1开始自动增长
```
INSERT INTO st6 (NAME, age) VALUES ('唐僧', 22);
INSERT INTO st6 (NAME, age) VALUES ('孙悟空', 26);
INSERT INTO st6 (NAME, age) VALUES ('猪八戒', 25);
INSERT INTO st6 (NAME, age) VALUES ('沙僧', 20);
```

-- 修改自动增长的开始值
```
ALTER TABLE st6 AUTO_INCREMENT = 10000;
```


-- 扩展delete和truncate的区别
-- delete只删除数据,不会重置主键的值,相当于你是房东,你把租客赶走了,房子还在
```
DELETE FROM st6;
```
-- truncate先删除表,删除这张表,在创建一张一样的表,相当于你是房东,你把房子拆了,有建立了一栋一样的房子
```
TRUNCATE st6;
```


-- 创建学生表st7, 包含字段(id, name),name这一列设置唯一约束,不能出现同名的学生
```
CREATE TABLE st7(
	id INT,
	NAME VARCHAR(20) UNIQUE
);


INSERT INTO st7 VALUES (1, '貂蝉');
INSERT INTO st7 VALUES (2, '西施');
INSERT INTO st7 VALUES (3, '王昭君');
```
-- 添加重名的数据: Duplicate entry '王昭君' for key 'name'
```
INSERT INTO st7 VALUES (4, '王昭君');
INSERT INTO st7 VALUES (4, NULL);
```

-- 创建表学生表st8, 包含字段(id,name,gender)其中name不能为NULL
```
CREATE TABLE st8 (
	id INT,
	NAME VARCHAR(20) NOT NULL,
	gender CHAR(1)
);

INSERT INTO st8 VALUES (1, '郭富城', '男');
INSERT INTO st8 VALUES (2, '黎明', '男');
INSERT INTO st8 VALUES (3, '张学友', '男');
INSERT INTO st8 VALUES (4, '刘德华', '男');
```
-- 添加一条name为null的数据: Column 'name' cannot be null
```
INSERT INTO st8 VALUES (4, NULL, '男');
```

-- 一个字段可以同时添加多个约束
```
CREATE TABLE stt(
	id INT,
	NAME VARCHAR(20) UNIQUE NOT NULL 
);
INSERT INTO stt VALUES(1, '张三');
INSERT INTO stt VALUES(2, NULL);
```

-- 默认值
-- 创建一个学生表st9，包含字段(id,name,address)， 地址默认值是广州
```
CREATE TABLE st9(
	id INT,
	NAME VARCHAR(20),
	address VARCHAR(100) DEFAULT '广州'
);
```

-- 添加一条记录,使用默认地址
```
INSERT INTO st9 (id, NAME) VALUES (1, '刘德华');
```

-- 添加一条记录,不使用默认地址
```
INSERT INTO st9 VALUES (2, '张学友', '香港');
```