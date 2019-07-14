package demo4;

public class Test2 {
    public static void main(String[] args) {
        SonPro s = new SonPro();
        s.go();

//        s.say();  no  接口的静态方法，实现类对象不能调用
        FatherPro.say();
    }
}