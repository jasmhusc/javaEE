package com.hsc.demo3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 初步模拟双人聊天，客户端读取控制台信息输出到服务器。
 */
public class UDPSender {
    public static void main(String[] args) throws Exception {

        // 创建socket
        DatagramSocket socket = new DatagramSocket();

        // 创建要发送数据，字节数组
        /*
            键盘录入来得到数据
         */
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if ("bye".equals(line))
                break;
            byte[] bytes = line.getBytes();

            // 创建packet(需要指定ip和port)
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getLocalHost(), 6666);

            // 发送数据
            socket.send(packet);

        }
        // 关闭socket
        socket.close();
    }
}
