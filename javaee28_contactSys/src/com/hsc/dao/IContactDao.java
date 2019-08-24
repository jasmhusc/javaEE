package com.hsc.dao;

import com.hsc.entity.Contact;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

// 联系人列表
public interface IContactDao {

    // 查询所有数据
    @Select("SELECT * FROM contact;")
    List<Contact> findAll();

    // 根据id查询一个联系人
    @Select("SELECT * FROM contact WHERE id = #{id};")
    Contact findById(int id);

    // 更新联系人信息
    @Update("UPDATE contact SET name=#{name},sex=#{sex},address=#{address},qq=#{qq},email=#{email} WHERE id=#{id};")
    void update(Contact contact);

    // 添加联系人信息
    @Insert("INSERT INTO contact VALUES (#{id},#{name},#{sex},#{age},#{address},#{qq},#{email});")
    void add(Contact contact);

    // 删除联系人信息
    @Delete("DELETE FROM contact WHERE id = #{id};")
    void delete(int id);
}
