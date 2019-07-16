package demo8;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 1.泛型通配符?用在方法参数上
 * 案例：遍历所有ArrayList集合里面的元素
 * <p>
 * 2. ？ extends Fruit  向上限定
 * 3. ？ super Fruit   向下限定
 */
public class WildCardDemo {

    public static void main(String[] args) {

        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Fruit> fruitList = new ArrayList<>();
        ArrayList<Apple> appleList = new ArrayList<>();
        ArrayList<Orange> orangeList = new ArrayList<>();

//      泛型为 通配符 ？ 可以接受任意类型，接受后默认按Object类型对待
        ergodic(strList);
        ergodic(appleList);

        // Fruit 本类
        fruitList.add(new Fruit());
        fruitShow(fruitList);

        // Fruit 的子类
        orangeList.add(new Orange());
        fruitShow(orangeList);
    }

    /*
     *  1.向上限定泛型 只有 Fruit 有show方法。
     *  2.这是一个生产者，即一个容器，我们把某中特定集合放到里面去。
     *  3.对于消费者而言，是一个特定类型接收者，接收后执行某种功能，不是容器。
     * */
    private static void fruitShow(ArrayList<? extends Fruit> list) {
        for (Fruit fruit : list) {
            fruit.show();
            System.out.println();
        }
    }

    private static void ergodic(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
        }
    }
}
