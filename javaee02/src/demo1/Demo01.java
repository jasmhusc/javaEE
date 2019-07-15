package demo1;

public interface Demo01 {
  /*
    接口体现的是一种规范
  * 接口的成员特点:
        1.接口中的成员方法默认会添加:public abstract
        2.接口中的成员变量默认会添加:public static final(常量)*/
    int a = 5;
    public static final double PI = 3.14;
    void pay();
    public abstract void dowork();
}
