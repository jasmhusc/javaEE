package com.hsc.bean;

public class Employee {
    private String name;
    private int age;
    public double weight;
    public double height;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Employee(String name) {
        this.name = name;
    }

    protected Employee(int age) {
        this.age = age;
    }

    private int sleep(int hour) {
        System.out.println("睡了" + hour + "小时");
        return hour * 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // sssss
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
