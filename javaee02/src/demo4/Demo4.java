package demo4;

public class Demo4 {
/*
* 讲解:
    静态方法的格式:
        修饰符 static 返回值类型 方法名(参数列表) {

        }

    接口_静态方法的使用:
        接口的静态方法只能使用接口名调用

小结:
    接口_静态方法的使用:
        接口的静态方法只能使用接口名调用*/
    public static void main(String[] args) {
        /*接口的静态方法不能使用,实现类对象来调用
        Student s = new Student();
        s.LOL();*/
        Play.LOL();
    }
}
