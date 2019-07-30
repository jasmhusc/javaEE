package com.hsc.demo5;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Properties;

public class UDPReceiverPro implements Runnable {
    private int port;

    public UDPReceiverPro(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(port);
            DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);
            while (true) {
                // 接收数据
                socket.receive(packet);
                // 解析数据
                byte[] data = packet.getData();
                int len = packet.getLength();
                InetAddress ip = packet.getAddress();
                String hostname = ip.getHostName();
                String nickname = getValue(hostname);
                // 判断上线，下线
                if (data[0] == -1 && len == 3) {
                    System.out.println("系统：" + nickname + "已上线");
                    continue;
                }
                String word = new String(data, 0, len);

                if (data[0] == -1 && len == 2) {
                    System.out.println("系统：" + nickname + "已下线");
                    continue;
                }
                // 聊天语句输出
                System.out.println(nickname + "：" + word);
            }
        } catch (Exception e) {
            System.out.println("服务器异常，等待修复...");
        }
    }

    private String getValue(String hostname) {
        String nickname = "隔壁老王";
        // 加载properties数据
        Properties pp = new Properties();
        try {
            pp.load(new FileInputStream("javaee11/upload/users.properties"));
        } catch (IOException e) {
        }
        // 取出value
        String value = pp.getProperty(hostname);
        if (null != value)
            nickname = value;
        return nickname;
    }
}
