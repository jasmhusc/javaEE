package com.hsc.demo11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Runnable {
    private int port;

    public TCPServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            // 建立服务器socket，指定port，接受连接
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();

            // 接收数据，打印到控制台
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("网络异常...");
        }
    }
}
