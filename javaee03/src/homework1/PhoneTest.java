package homework1;

public class PhoneTest {
    public static void main(String[] args) {

        Phone phone = new Phone() {
            @Override
            public void call() {
                System.out.println("call...");
            }

            @Override
            public void sendMessage() {
                System.out.println("sendMassage...");
            }
        };

        phone.call();
        phone.sendMessage();
    }
}

interface Phone {
    void call();

    void sendMessage();
}
