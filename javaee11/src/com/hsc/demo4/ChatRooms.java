package com.hsc.demo4;

/**
 * Thread实现双人聊天通信。
 */
public class ChatRooms {
    public static void main(String[] args) {

        // 开启客户端和服务端的聊天线程
        new UDPReceiver().start();
        new UDPSender().start();
    }
}
