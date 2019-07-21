package demo5;

public class AgeOutOfBoundsException extends Throwable {

    // 无参构造
    public AgeOutOfBoundsException() {
    }

    // 有参构造
    public AgeOutOfBoundsException(String message) {
        super(message);
    }
}
