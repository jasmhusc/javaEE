package com.hsc.entity;

// value object 值对象, 这个对象,就是放一些数据.
public class QueryVo {
    private String username;
    private String sex;

    public QueryVo() {
    }

    public QueryVo(String username, String sex) {
        this.username = username;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
