package com.hsc.entity;

// value object 值对象, 这个对象,就是放一些数据.
public class QueryVo {
    private User user;
    private String start;
    private String end;

    public QueryVo() {
    }

    public QueryVo(User user, String start, String end) {
        this.user = user;
        this.start = start;
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
