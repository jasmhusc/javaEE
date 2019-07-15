package demo04;

public class Body {
    private static boolean isAlive = true;
    private static String heartColor = "red";

    public static void walk() {

        System.out.println("I'm walking !");
    }

    static class Heart {
        private String heartColor = "blue";

        public void boom() {
            String heartColor = "green";
//            可以直接使用外部类的静态成员变量和静态成员方法
            if (isAlive) {
                System.out.println(heartColor + " ..Boom");
                System.out.println(this.heartColor + " ..Boom");
                System.out.println(Body.heartColor + " ..Boom");
                walk();
            } else {
                System.out.println("I'm dead !");
            }
        }
    }
}
