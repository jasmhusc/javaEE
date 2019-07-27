package com.hsc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟用户登录，服务器不用关闭。
 */
public class Test_Words {

    public static void main(String[] args) throws IOException {

        // 创建服务器，获取输入流和输出流
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter ps = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            String users = br.readLine();
            String password = br.readLine();
		    /*if("users".equals(users) && "password".equals(password)) {
			ps.println("登录成功！");
		    }*/
            if (UsersDB.getUsers().contains(new Users(users, password))) {
                ps.println("登录成功！");
                break;
            }
            ps.println("登录失败！");
            //socket.close();
        }
    }
}
