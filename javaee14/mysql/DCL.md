### 创建数据库
```
CREATE DATABASE day15;
```

-- 创建用户
```
创建user1用户只能在localhost这个IP登录mysql服务器
   CREATE USER 'user1'@'localhost' IDENTIFIED BY '123';
```

-- 创建user2用户可以在任何电脑上登录mysql服务器
```
CREATE USER 'user2'@'%' IDENTIFIED BY '123';
```

### 授权用户
```
给user1用户分配对db1这个数据库的student表
CREATE,ALTER,DROP,INSERT,UPDATE,DELETE,SELECT的权限
GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT ON db1.`student` TO 'user1'@'localhost';
```

-- 给user2用户分配对所有数据库操作的权限
```
GRANT ALL ON *.* TO 'user2'@'%';
```


### 撤销授权
-- 撤销user1用户对db1操作的权限
```
REVOKE SELECT, DROP ON db1.student FROM 'user1'@'localhost';
```

### 查看权限
```
SHOW GRANTS FOR 'user1'@'localhost';
```

### 删除用户
-- 删除user2
```
DROP USER 'user2'@'%';
```