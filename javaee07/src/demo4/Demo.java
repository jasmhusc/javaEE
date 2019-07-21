package demo4;

public class Demo {
    public static void main(String[] args) {

        String[] users = {"bill", "hill", "jill", "kill", "cill"};

        try {
//            checkUserName(users,"dill");
            checkUserName(users, "kill");
            System.out.println("注册成功！");
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkUserName(String[] users, String name) throws LoginException {
//     方法声明上抛出异常
        for (String user : users) {
            if (name.equals(user))
                throw new LoginException("亲，" + name + "已经被注册了！");
        }
        return true;
    }

    // 定义一个检查用户名的函数，用户名存在就抛出异常

}
