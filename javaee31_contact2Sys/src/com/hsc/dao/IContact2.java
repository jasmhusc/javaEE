package com.hsc.dao;

import com.hsc.entity.Contact2;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IContact2 {
    // 查询contact2的数据
    @Select("SELECT * FROM contact2")
    List<Contact2> findAll();
}
