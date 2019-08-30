package com.hsc.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 一对多：个人订单表
 * 一个人对应多个订单
 */
public class OrderForm implements Serializable {
    private int oid;
    private int userId;
    private String number;
    /*
    create_time在表中为DateTime类型，java里是
     */
    private Timestamp createTime;
    private String note;

    public OrderForm() {
    }

    public OrderForm(int oid, int userId, String number, Timestamp createTime, String note) {
        this.oid = oid;
        this.userId = userId;
        this.number = number;
        this.createTime = createTime;
        this.note = note;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "oid=" + oid +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createTime=" + createTime +
                ", note='" + note + '\'' +
                '}';
    }
}
