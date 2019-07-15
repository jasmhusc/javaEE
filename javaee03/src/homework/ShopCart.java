package homework;

import java.util.ArrayList;
import java.util.Iterator;

public class ShopCart {
    private ArrayList<Goods> cart;

    public ShopCart() {
        cart = new ArrayList<Goods>();
    }

    public void add(Goods g) {
        cart.add(g);
        System.out.println("添加 " + g.getGoodsname() + " 成功");
    }

    public void show() {
        System.out.println("==========打印商品=========");
        System.out.println("您选购的商品为：");
        Iterator<Goods> it = cart.iterator();
        while (it.hasNext()) {
            Goods goods = it.next();
            System.out.println(goods);
        }
    }

    public void total() {
        System.out.println("--------------------");
        double sum = 0;
        for (Goods goods : cart) {
            sum += goods.getPrice();
        }
        System.out.println("原价为： " + sum + "元");
        System.out.println("折后价为： " + sum * 0.88 + "元");
    }
}
