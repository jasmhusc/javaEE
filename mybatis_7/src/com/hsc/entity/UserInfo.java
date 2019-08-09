package com.hsc.entity;

/**
 * 一对一关联表：一个用户包含一份个人扩展信息
 */
public class UserInfo {
    private int id;
    private double height;
    private double weight;
    /*
     married表中定义的是TinyChar,值为0，1
     此处定义为boolean，mybatis会自动进行转换。
      */
    private boolean married;

    public UserInfo() {
    }

    public UserInfo(int id, double height, double weight, boolean married) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.married = married;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                ", married=" + married +
                '}';
    }
}
