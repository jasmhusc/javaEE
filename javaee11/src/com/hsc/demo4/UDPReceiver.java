package com.hsc.demo4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 聊天多线程版本，服务器一直开启。
 */
public class UDPReceiver extends Thread {
    @Override
    public void run() {
        try {
            // socket指定端口，packet指定接收数据的数组大小
            DatagramSocket socket = new DatagramSocket(5555);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

            while (true) {
                // 接收数据，获取发送者信息
                socket.receive(packet);
                String ip = packet.getAddress().getHostAddress();
                byte[] data = packet.getData();
                int length = packet.getLength();
                System.out.println(ip + ": " + new String(data, 0, length));
            }
        } catch (Exception e) {
            System.out.println("网络异常！");
        }
    }
}
