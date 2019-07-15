package homework;

public class Goods {
    private String id;
    private String goodsname;
    private double price;

    public Goods() {
    }

    public Goods(String id, String goodsname, double price) {
        this.id = id;
        this.goodsname = goodsname;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\t" +
                id + '\'' +
                ", " + goodsname + '\'' +
                ", " + price;
    }
}
