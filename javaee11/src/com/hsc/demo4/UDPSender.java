package com.hsc.demo4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSender extends Thread {

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            while (true) {
                // 获取键盘录入
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();
                byte[] buf = line.getBytes();
                // 判断是否为结束语：bye
                if ("bye".equals(line))
                    break;
                // 创建socket和packet
                DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 5555);

                // 发送数据
                socket.send(packet);
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("您已断开连接！");
        }
    }
}
