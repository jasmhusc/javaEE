package demo6;

public class SingletonDemo {
    private static SingletonDemo obj = new SingletonDemo();  //共享一个obj对象
    private String content;
    private SingletonDemo() {
        this.content = "abcd";    //确保只能在类内部调用构造函数
    }                              // 类外的其他类，无法进行 new Singleton()操作获取对象

    public String getContent() {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public static SingletonDemo getInstance() {

        return obj;              // 外界只能通过此方法获取对象，而所获得的都是 obj 对象
    }

    public static void main(String[] args) {
        SingletonDemo kk = new SingletonDemo();
        kk.setContent("efghijk");
        System.out.println(kk.getContent());   // 类内部可以调用构造函数，所以可以 new 一个对象kk
    }
}
