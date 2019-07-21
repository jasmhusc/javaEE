package demo3;

import java.sql.SQLException;

public class NameException extends SQLException {
    // 将信息传递给父类
    public NameException() {
    }

    public NameException(String message) {
        super(message);
    }
}
