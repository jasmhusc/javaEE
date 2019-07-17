package shopsystem;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Goods> shop;

    public Shop() {
        shop = new ArrayList<>();
    }

    public boolean add(Goods g) {
        boolean ret = false;
        if (g != null) {
            shop.add(g);
            ret = true;
        }
        return ret;
    }

    public void showGoods() {
        System.out.println("---------------------------");
        System.out.println("\t\t商品列表");
        System.out.println("商品id\t名称\t\t\t单价\t\t\t计价单位");
        for (Goods goods : shop) {
            System.out.println(goods.getId() + "\t\t" + goods.getName() + "\t\t" + goods.getPrice() + "\t\t  " + goods.getUnit());
        }
        System.out.println("---------------------------");
    }

    public boolean isExist(String id) {
        boolean flag = false;
        if (id != null) {
            for (Goods goods : shop) {
                String goodsId = goods.getId();
                if (id.equals(goodsId)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public Goods getById(String id) {
        Goods ret = null;
        if (id != null) {
            for (Goods goods : shop) {
                String goodsId = goods.getId();
                if (id.equals(goodsId)) {
                    ret = goods;
                    break;
                }
            }
        }
        return ret;
    }
}
