package com.hsc.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 在主表添加其他表的信息，作为成员变量：
 * 1. 一对一的关系，直接将另一个表作为成员变量: UserInfo userInfo;
 * 2. 一对多，将多方的集合作为成员变量: Order orders;
 * 3. 多对一，同2，自己成为被添加的多方；
 * 4. 多对多，结合2和3，双方互相成为对方的多方，在各自的javabean类里添加对方集合变量。
 * <p>
 * 没多一张表就要多一个成员变量，并且重新生成：有参构造函数，setters和getters，toString()
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    // 一对一：UserInfo，个人的扩展信息
    private UserInfo userInfo;

    // 一对多：一个人对应多张订单
    private List<OrderForm> orders;

    // 多对多：用户和角色，互相添加对方集合
    private List<Role> roles;

    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String address, UserInfo userInfo, List<OrderForm> orders, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.userInfo = userInfo;
        this.orders = orders;
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<OrderForm> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderForm> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", userInfo=" + userInfo +
                ", orders=" + orders +
                ", roles=" + roles +
                '}';
    }
}
