package com.hsc.lodin.view;

import com.hsc.lodin.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

/*
表示层,和用户交互,收集用户数据,给用户登录的结果
 */
public class View {
    public static void main(String[] args) {

        // 键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String userName = sc.nextLine();
        System.out.println("请输入密码:");
        String password = sc.nextLine();

        // 得到用户的账号和密码,调用业务层的登录功能
        UserService service = new UserService();
        try {
            boolean b = service.Loadin(userName, password);
            if (b)
                System.out.println("恭喜您, " + userName + "登录成功");
            else
                System.out.println("账号名或密码错误");
        } catch (SQLException e) {
            System.out.println("服务器繁忙，请稍后再试！");
        }
    }
}
