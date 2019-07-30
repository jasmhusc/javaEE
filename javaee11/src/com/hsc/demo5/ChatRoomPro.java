package com.hsc.demo5;

/**
 * Runnable实现多人聊天室，提示用户上下功能。
 */
public class ChatRoomPro {
    public static void main(String[] args) {

        // 创建连接
        UDPReceiverPro service = new UDPReceiverPro(5555);
        UDPSenderPro client = new UDPSenderPro("192.168.3.5", 5555);

        // 开启服务器和客户端
        new Thread(service).start();
        new Thread(client).start();
    }
}
