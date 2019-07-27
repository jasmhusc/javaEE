package com.hsc.demo5;

/**
 * Runnable实现多人聊天室，提示用户上下功能。
 */
public class ChatRoomPro {
    public static void main(String[] args) {

        // 开启服务器和客户端
        new Thread(new UDPReceiverPro()).start();
        new Thread(new UDPSenderPro()).start();
    }
}
