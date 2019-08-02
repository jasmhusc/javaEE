## DML操作表
- 创建student表包含id,name,birthday,sex,address字段
CREATE TABLE student(
	id INT,
	NAME VARCHAR(20),
	birthday DATE,
	sex CHAR(1),
	address VARCHAR(100)
);

### 添加数据：insert into
1. 插入数据,所有的字段名都写出来
INSERT INTO student (id, NAME, birthday, sex, address) VALUES (1, '马云', '1965-05-05', '男', '杭州');

2. 可以不按顺序来
INSERT INTO student (address, sex, birthday, id, NAME) VALUES 
	('深圳', '男', '1970-07-07', 2, '马化腾');

3. 插入数据,不写字段名
INSERT INTO student VALUES (3, '刘强东', '1977-08-08', '妖', '宿迁');

4. 插入部分数据，往学生表中添加部分数据
INSERT INTO student (id, NAME, sex) VALUES (4, '撒贝宁', '男');
INSERT INTO student (id, NAME, sex) VALUES (5, '王健林', '未');


### 修改数据：update...set...
1. 不带条件修改数据，将所有的性别改成女
UPDATE student SET sex='女';

2. 带条件修改数据，将id号为1的学生性别改成男
UPDATE student SET sex='男' WHERE id=1;

3. 一次修改多个列，把id为3的学生，生日改成1988-08-08，address改成北京
UPDATE student SET birthday='1988-08-08', address='北京' WHERE id=3;

4. 带条件删除数据，删除id为3的记录
DELETE FROM student WHERE id=3;

5. 不带条件删除数据,删除表中的所有数据
DELETE FROM student;