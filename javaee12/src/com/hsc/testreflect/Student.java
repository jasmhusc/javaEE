package com.hsc.testreflect;

public class Student {

    private String name;
    private Integer id;
    private int age;

    public Student() {
        super();

    }

    public Student(String name, Integer id, int age) {
        super();
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", id=" + id + ", age=" + age + "]";
    }

}
