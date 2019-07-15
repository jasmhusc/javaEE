package demo03;

public class Demo3 {

    public static void main(String[] args) {
        // 创建外部类对象
        Body body = new Body();
//        创建内部类对象
//        Body.Heart h = new Body().new Heart();
        Body.Heart heart = body.new Heart();
        heart.boom();
    }
}
