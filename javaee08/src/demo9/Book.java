package demo9;

public class Book {
    private String name;
    private double price;

    public Book() {
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ",价格" + price + "元";
    }
}
