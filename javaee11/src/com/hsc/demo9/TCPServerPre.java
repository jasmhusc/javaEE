package com.hsc.demo9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerPre {
    public static void main(String[] args) throws IOException {

        // 创建ServerSocket对象服务器server
        ServerSocket server = new ServerSocket(2021);
        System.out.println("服务器启动...");
        while (true) {
            // server接收客户端请求，得到socket
            Socket socket = server.accept();

            new Thread(new ServerTask(socket)).start();
        }
    }
}
