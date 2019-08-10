-- DQL查询记录

-- 查询student表中所有字段
```
SELECT sex, id, NAME, birthday, address FROM student;
```


-- 查询所有字段,使用*代表所有列
```
SELECT * FROM student;
```

-- 查询student表中的name 和 birthday 列
```
SELECT NAME, birthday FROM student;
```


-- 查询sudent表中name 和 birthday 列，
-- name列的别名为 姓名，birtyday列的别名为 生日
```
SELECT NAME AS 姓名, birthday AS 生日 FROM student;
```

-- 取别名时AS关键字可以省略
```
SELECT NAME 姓名2, birthday 生日2 FROM student;
```

-- 查询address列并且结果不出现重复的address
```
SELECT DISTINCT address FROM student;
```

-- 添加数学，英语成绩列，给每条记录添加对应的数学和英语成绩
-- 给sutdent添加数学和英语2列
```
ALTER TABLE student ADD math INT;
ALTER TABLE student ADD english INT;
ALTER TABLE student ADD math INT, ADD english INT;
```

-- 查询结果参与运算
-- 查询math + english的和
```
SELECT math + english FROM student;
```


-- 查询所有字段与 math + english别名为 总分
```
SELECT math + english 总分 FROM student;
```


-- 查询姓名、地址，将每个人的数学增加10分
```
SELECT NAME, address, math + 10 FROM student;
```


-- 蠕虫复制
-- 创建student2表，student2结构和student表结构一样
```
CREATE TABLE student2 LIKE student;
```

-- 将student表中的数据添加到student2表中
```
INSERT INTO student2 SELECT * FROM student;
```

-- 扩展
```
INSERT INTO student2 (id, NAME, sex, address) SELECT id, NAME, sex, address FROM student;
```


-- 条件查询
-- 准备数据
```
CREATE TABLE student3 (
  id INT,
  NAME VARCHAR(20),
  age INT,
  sex VARCHAR(5),
  address VARCHAR(100),
  math INT,
  english INT
);


INSERT INTO student3(id,NAME,age,sex,address,math,english) VALUES
 (1,'马云',55,'男','杭州',66,78),
 (2,'马化腾',45,'女','深圳',98,87),
 (3,'马景涛',55,'男','香港',56,77),
 (4,'柳岩',20,'女','湖南',76,65),
 (5,'柳青',20,'男','湖南',86,NULL),
 (6,'刘德华',57,'男','香港',99,99),
 (7,'马德',22,'女','香港',99,99),
 (8,'德玛西亚',18,'男','南京',56,65);
```
-- 查询math分数大于80分的学生
```
SELECT * FROM student3 WHERE math > 80;
```


-- 查询english分数小于等于90分的学生
```
SELECT * FROM student3 WHERE english <= 90;
```

-- 查询age不等于20岁的学生
```
SELECT * FROM student3 WHERE age != 20;
SELECT * FROM student3 WHERE age <> 20;
```

-- 逻辑运算符
-- 查询age大于35且性别为男的学生(两个条件同时满足)
```
SELECT * FROM student3 WHERE age > 35 && sex='男';
SELECT * FROM student3 WHERE age > 35 AND sex='男';
```

-- 查询age大于35或性别为女的学生(两个条件其中一个满足)
```
SELECT * FROM student3 WHERE age > 35 || sex='女';
SELECT * FROM student3 WHERE age > 35 OR sex='女';
```

-- 查询id是1或3或5的学生
```
SELECT * FROM student3 WHERE id=1 OR id=3 OR id=5;
```

-- in: 在...里面,只要是满足()里面的数据都可以
-- 查询id是1或3或5的学生
```
SELECT * FROM student3 WHERE id IN (1, 3, 5);

SELECT * FROM student3 WHERE id NOT IN (1, 3, 5);
```

-- 范围: BETWEEN 值1 AND 值2 -- 表示从值1到值2范围，包头又包尾
-- 查询english成绩大于等于75，且小于等于90的学生
```
SELECT * FROM student3 WHERE english >= 75 AND english <= 90;
SELECT * FROM student3 WHERE english BETWEEN 75 AND 90;
```

-- 注意: between 值1 and 值2, 小的写前面大的写后面
```
SELECT * FROM student3 WHERE english BETWEEN 90 AND 75;
```

-- 模糊查询like
-- 查询姓马的学生: 第一个是马,后面无所谓
```
SELECT * FROM student3 WHERE NAME LIKE '马%';
```

-- 查询姓名中包含'德'字的学生
```
SELECT * FROM student3 WHERE NAME LIKE '%德%';
```


-- 查询姓马，且姓名有三个字的学生
```
SELECT * FROM student3 WHERE NAME LIKE '马__';
```

-- 查询姓马的或姓柳的
```
SELECT * FROM student3 WHERE NAME LIKE '马%' OR NAME LIKE '柳%';
```

-- 排序
-- 单列排序
-- 查询所有数据,使用年龄升序排序
```
SELECT * FROM student3 ORDER BY age ASC;
```

-- 查询所有数据,使用年龄降序排序
```
SELECT * FROM student3 ORDER BY age DESC;
```


-- 组合排序
-- 查询所有数据,在年龄降序排序的基础上，如果年龄相同再以数学成绩降序排序
```
SELECT * FROM student3 ORDER BY age DESC, math DESC;
```

-- 聚合函数
-- SELECT 聚合函数(字段) FROM 表名;
-- 查询学生总数: count统计的时候NULL不算
```
SELECT COUNT(id) FROM student3;
SELECT COUNT(english) FROM student3;
```

-- 通常是这样使用
```
SELECT COUNT(*) FROM student3;
```

-- 查询年龄大于40的总数
```
SELECT COUNT(*) FROM student3 WHERE age > 40;
```

-- 查询数学成绩总分
```
SELECT SUM(math) FROM student3;
```

-- 查询数学成绩最低分
```
SELECT MIN(math) FROM student3;
```


-- 查询数学成绩平均分: avg average
```
SELECT AVG(math) FROM student3;

SELECT FORMAT(AVG(math), 2) FROM student3;
-- format(x,d) x:数据 d:小数位数
```
-- 了解:求数学成绩最大值和最小值的差
```
SELECT MAX(math) - MIN(math) FROM student3;
```

-- 分组查询
```
SELECT * FROM student3 GROUP BY sex;
```
-- 按性别分组: 注意,一般分组都会查询出分组的字段
```
SELECT sex FROM student3 GROUP BY sex;
```

-- 查询男女各多少人
-- 先按性别分组, 男,女
-- 使用聚合函数统计每组的数量
```
SELECT sex, COUNT(*) FROM student3 GROUP BY sex;
```

-- 查询年龄大于25岁的人,按性别分组,统计每组的人数
```
SELECT sex, COUNT(*) FROM student3 WHERE age > 25 GROUP BY sex;
```

-- 查询年龄大于25岁的人,按性别分组,统计每组的人数,并只显示性别人数大于2的数据
```
SELECT sex, COUNT(*) FROM student3 WHERE age > 25 GROUP BY sex HAVING COUNT(*) > 2; 
```

-- limit
-- 准备数据
```
INSERT INTO student3(id,NAME,age,sex,address,math,english) VALUES 
(9,'唐僧',25,'男','长安',87,78),
(10,'孙悟空',18,'男','花果山',100,66),
(11,'猪八戒',22,'男','高老庄',58,78),
(12,'沙僧',50,'男','流沙河',77,88),
(13,'白骨精',22,'女','白虎岭',66,66),
(14,'蜘蛛精',23,'女','盘丝洞',88,88);
```
-- 查询学生表中数据，跳过前面2条，显示6条
```
SELECT * FROM student3 LIMIT 2, 6;
```

-- 假设我们一每页显示5条记录的方式来分页，SQL语句如下：
-- 第一页: 跳过0条件, 获取5条
```
SELECT * FROM student3 LIMIT 0, 5;
```
-- 如果跳过的条数是0,可以省略
```
SELECT * FROM student3 LIMIT 5;
```

-- 第二页: 跳过5条件, 获取5条
```
SELECT * FROM student3 LIMIT 5, 5;
```

-- 第三页: 跳过10条件, 获取5条
```
SELECT * FROM student3 LIMIT 10, 5;
```