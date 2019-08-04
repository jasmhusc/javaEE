package com.hsc.lodin.dao;

/*
这个数据访问层,专门操作数据库的, 负责执行SQL语句
 */
public interface UserDao {
    /**
     * 添加数据
     */
    void insert(String username, int age, String password);

    /**
     * 删除数据
     */
    void delete(int id);

    /**
     * 更新数据
     */
    void update(int id, String password);

    /**
     * 查询所有数据
     */
    void findAll();

    /**
     * 查询单条数据
     */
    Boolean query(String username, String password);
}
