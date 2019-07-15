package demo03;

public class Body {
    private boolean isAlive = true;
    private String heartColor = "red";

    public void walk() {

        System.out.println("I'm walking !");
    }

    class Heart {
        private String heartColor = "blue";

        public void boom() {
            String heartColor = "green";
//            可以直接使用外部类的成员变量和成员方法
            if (isAlive) {
                System.out.println(heartColor + " ..Boom");
                System.out.println(this.heartColor + " ..Boom");
                System.out.println(Body.this.heartColor + " ..Boom");
                walk();
            } else {
                System.out.println("I'm dead !");
            }
        }
    }
}
