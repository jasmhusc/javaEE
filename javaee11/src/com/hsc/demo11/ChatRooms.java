package com.hsc.demo11;

public class ChatRooms {
    public static void main(String[] args) {

        // 指定服务器ip和port
        String ip = "192.168.3.5";
        int port = 6666;

        // 开启服务器和客户端

        new Thread(new TCPServer(port)).start();

        new Thread(new TCPClient(ip, port)).start();
    }
}
