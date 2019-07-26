package com.hsc.demo2;

import java.io.IOException;
import java.net.*;

public class UDPSend {
    public static void main(String[] args) throws IOException {

        // 准备数据
        String str = "你好，HelloWorld!";
        byte[] bytes = str.getBytes();

        // 创建发送端对象（建立码头）
        DatagramSocket socket = new DatagramSocket();

        // 创建数据包对象（集装箱）
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getLocalHost(), 6666);

        // 发送数据包
        socket.send(packet);

        // 关闭资源,关闭发送对象，释放端口号
        socket.close();
    }
}
