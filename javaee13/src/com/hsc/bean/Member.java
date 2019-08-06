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
    @SQLInteger(name = "ID", constrain = @Constraints(primaryKey = true, autoIncrement = true))
    private Integer id;

    // name 长度20
    @SQLString(name = "NAME", value = 20)
    private String name;

    // age
    @SQLInteger(name = "AGE")
    private Integer age;

    // description 描述信息，长度100，允许空值
    @SQLString(name = "DESCRIPTION", value = 100, constraint = @Constraints(allowNull = true))
    private String description;
}
