package com.hsc.reflect;

@SuppressWarnings("all")
public class Goods extends Foods implements Book {

    private String name;
    private Double price;
    private Integer storage;

    public Goods() {
        super();
        System.out.println("无参构造");
    }

    private Goods(String name, Integer storage) {
        super();
        this.name = name;
        this.storage = storage;
        System.out.println("私有有参构造");
    }

    public Goods(String name, Double price, Integer storage) {
        super();
        this.name = name;
        this.price = price;
        this.storage = storage;
        System.out.println("公有有参构造");
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        storage = storage;
    }

    @Override
    public String toString() {
        return "Goods [name=" + name + ", price=" + price + ", storage=" + storage + "]";
    }


}
