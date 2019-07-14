package demo1;

public class Test1 {
    public static void main(String[] args) {
        A a = new A();
        a.dowork();

        System.out.println(a.PI);  // 不推荐
//        Demo01.a = 3;  不能被重新赋值
    }
}

class A implements Demo01{
    @Override
    public void pay() {

    }

    @Override
    public void dowork() {
        System.out.println("dowork");
    }
}