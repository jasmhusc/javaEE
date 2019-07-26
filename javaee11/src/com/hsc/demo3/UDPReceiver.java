package com.hsc.demo3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 初步模拟双人聊天，服务器接收数据，打印输出。
 */
public class UDPReceiver {
    public static void main(String[] args) throws Exception {

        // 创建socket
        DatagramSocket socket = new DatagramSocket(6666);

        // 创建packet接收数据
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

        while (true) {
            // 数据用packet接收
            socket.receive(packet);

            // 数据获取
            byte[] data = packet.getData();
            int len = packet.getLength();
            System.out.println(new String(data, 0, len));
        }
    }
}
