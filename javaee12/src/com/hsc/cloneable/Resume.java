package com.hsc.cloneable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Resume implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private PhoneNum phone;
    private String company;
    private String address;

    public void setInfo(String name, int age, PhoneNum phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public void setWork(String company, String address) {
        this.company = company;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PhoneNum getPhone() {
        return phone;
    }

    public void setPhone(PhoneNum phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    public Object deepClone() throws Exception {

        // 创建内存缓冲区 bos
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        // this指向调用该方法的对象
        oos.writeObject(this);

        byte[] by = bos.toByteArray();
        ByteArrayInputStream bas = new ByteArrayInputStream(by);
        ObjectInputStream ois = new ObjectInputStream(bas);
        Object Object = ois.readObject();

        // 返回的是Object类对象
        return Object;
    }

    public void show() {
        System.out.println("姓名：" + name + "，年龄：" + age + "，联系电话：" + phone.getPhone());
        System.out.println("公司名称：" + company + "，公司地址：" + address);
    }
}
