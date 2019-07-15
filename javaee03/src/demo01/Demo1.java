package demo01;

public class Demo1 {
    public static void main(String[] args) {
        int a = 10;

        test1(a);

        test2(new Person("李白",25));
    }

    // 传值
    public static void test1(int x){
        System.out.println(x);
    }

    // 传地址 方法西安书是类名，传入参数是对象
    public static void test2(Person p){
        System.out.println(p.getName()+" "+p.getAge());
    }
}
