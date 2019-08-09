package com.hsc.entity;

import java.util.List;

/**
 * 用户与角色多对多关系模型：
 * 一个用户对应多种角色
 * 一种角色可以有多个用户
 */
public class Role {
    private int roleId;
    private String roleName;
    private String roleDetail;
    // 一个role可以有多个用户
    private List<User> users;

    public Role() {
    }

    public Role(int roleId, String roleName, String roleDetail, List<User> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDetail = roleDetail;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDetail() {
        return roleDetail;
    }

    public void setRoleDetail(String roleDetail) {
        this.roleDetail = roleDetail;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDetail='" + roleDetail + '\'' +
                ", users=" + users +
                '}';
    }
}
