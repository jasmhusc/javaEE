package com.hsc.entity;

import java.util.List;

public class Rank {
    private int id;
    private String rankName;
    private List<User> users;

    public Rank() {
    }

    public Rank(int id, String rankName, List<User> users) {
        this.id = id;
        this.rankName = rankName;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", rankName='" + rankName + '\'' +
                ", users=" + users +
                '}';
    }
}
