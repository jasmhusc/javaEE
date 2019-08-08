package com.hsc.bean;

import com.hsc.annotation.Constraints;
import com.hsc.annotation.DBTable;
import com.hsc.annotation.SQLInteger;
import com.hsc.annotation.SQLString;

/**
 * Member类：
 * 成员变量：id,name,age,description
 */
@DBTable(name = "Member")
public class Member {
    // id 主键约束，自动增长
    @SQLInteger(name = "id", constraint = @Constraints(primaryKey = true, autoIncrement = true))
    private Integer id;

    // name 长度20
    @SQLString(name = "username", value = 20, constraint = @Constraints(notNull = true))
    private String name;

    // age
    @SQLInteger(name = "age", constraint = @Constraints(notNull = true))
    private Integer age;

    // description 描述信息，长度100，允许空值
    @SQLString(value = 100)
    private String description;
}
