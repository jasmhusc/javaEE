package demo3;

/*
  自定义异常，只写构造函数，构造函数将message逐层传递到父类
 */
public class PriceException extends Exception {

    public PriceException() {
    }

    public PriceException(String message) {
        super(message);
    }
}
