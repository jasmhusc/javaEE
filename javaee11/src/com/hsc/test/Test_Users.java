package com.hsc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Test_Users {

    public static void main(String[] args) throws IOException {

        int k = 0;
        int a = 3;  // 给予机会次数
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);  // 自动刷新
        BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
            if (k < a) {
                System.out.println("请输入用户名：");
                String userName = br.readLine();
                System.out.println("请输入密码：");
                String passWord = br.readLine();

                pw.println(userName);
                pw.println(passWord);

                String result = bfr.readLine();
                k++;
                if ("登录成功！".equals(result)) {
                    System.out.println(result);
                    break;
                } else if (k == (a - 1)) {
                    System.out.println(result + "您还有最后一次机会！");
                } else if (k < (a - 1)) {
                    System.out.println(result + "您还有" + (a - k) + "次机会！");
                }
            } else {
                System.out.println("登陆失败！");
                System.out.println("您的机会已用完，请明天再来！");
                break;
            }
        }
        bfr.close();
        br.close();
        socket.close();
    }
}
