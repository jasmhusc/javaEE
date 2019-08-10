package com.hsc.entity;

import java.sql.Date;

/**
 * 通过用户名模糊查询，生日最小值，最大值的区间;
 * 三个条件组合查询多个用户。
 */
public class Condition {
    private String name;
    private Date minDate;
    private Date maxDate;

    public Condition() {
    }

    public Condition(String name, Date minDate, Date maxDate) {
        this.name = name;
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "name='" + name + '\'' +
                ", minDate=" + minDate +
                ", maxDate=" + maxDate +
                '}';
    }
}
