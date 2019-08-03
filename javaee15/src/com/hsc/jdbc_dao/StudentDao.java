package com.hsc.jdbc_dao;

public interface StudentDao {
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
     * 查询数据
     */
    void findAll();

    /**
     * 用户登录
     */
    void loadin(String username, String password);
}
