package demo1;

public abstract class LandAnimal implements Animal {

//    eat() 在 Animal 中定义为抽象方法
//    public abstract void eat()
//    本抽象类只重写部分抽象方法：move()，保留其他抽象方法：eat()

    @Override
    public void move() {

        ran();  // 来自接口 Animal的 public default 方法
        Animal.sleep();  // 不能直接使用父接口内的 public static方法，但可以用接口名. 调用。
        System.out.println("LandAnimal:I Can Move By Feet!");
    }
}
