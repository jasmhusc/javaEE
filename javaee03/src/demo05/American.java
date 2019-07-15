package demo05;

public class American {
    String language = "English";

    public void speak() {

        // 在方法中的类，局部内部类
        class Joke {
            int num = 3;

            public void joke() {
                System.out.println("Make" + num + "jokes in " + language);
            }
        }
//        在方法中创建对象并调用局部内部类的方法，也可以直接使用外部类的成员变量和成员方法
//        不能在本方法外使用
        Joke joke = new Joke();
        joke.joke();
    }
}
