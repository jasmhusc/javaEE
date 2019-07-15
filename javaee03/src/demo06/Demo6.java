package demo06;

public class Demo6 {

    public static void main(String[] args) {
//        创建实例类
        new Student().smoke();
//        匿名内部类
        new Smokeable() {
            @Override
            public void smoke() {
                System.out.println("smoking....");
            }
        }.smoke();
    }
}
