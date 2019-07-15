package homework;

public class GoodsTest {
    public static void main(String[] args) {

        System.out.println("==========添加商品=========");
        ShopCart shopCart = new ShopCart();
        shopCart.add(new Laptop("g1000", "笔记本", 10000.0));
        shopCart.add(new Phones("g1001", "手机", 5000.0));
        shopCart.add(new Fruit("g1002", "苹果", 50.0));
        shopCart.show();
        shopCart.total();
    }
}
