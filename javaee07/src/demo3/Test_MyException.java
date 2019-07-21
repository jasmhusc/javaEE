package demo3;

public class Test_MyException {
    public static void main(String[] args) throws NameException, PriceException {

        // 测试自定义异常
        Animal a = new Animal();

        // set方法设置name
        a.setName("dog");

        // 设置price
        a.setPrice(32.6);
    }
}
