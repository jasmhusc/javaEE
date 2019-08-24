package com.hsc.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private int rankId;
    private Rank rank;

    public User() {
    }

    public User(int id, String username, String password, int rankId, Rank rank) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rankId = rankId;
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rankId=" + rankId +
                ", rank=" + rank +
                '}';
    }
}
