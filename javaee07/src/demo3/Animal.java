package demo3;

public class Animal {
    private String name;
    private double price;

    public Animal() {
    }

    public Animal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {

        return price;
    }

    public void setName(String name) throws NameException {

        if (name.length() < 4) {
            throw new NameException("名字太短啦！");
        }
        this.name = name;
    }

    public void setPrice(double price) throws PriceException {
        if (price > 30)
            throw new PriceException("价格太坑爹了！");
        this.price = price;
    }
}
