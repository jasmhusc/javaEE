package com.hsc.demo5;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Properties;

public class UDPReceiverPro implements Runnable {
    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(5555);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                // 接收数据
                socket.receive(packet);
                // 解析数据
                byte[] data = packet.getData();
                int len = packet.getLength();
                String key = packet.getAddress().getHostName();
                String name = getValue(key);
                // 判断上线，下线
                if (data[0] == -1 && len == 3) {
                    System.out.println("系统：" + name + "已上线");
                    continue;
                }
                String word = new String(data, 0, len);
                String ip = packet.getAddress().getHostAddress();

                if (data[0] == -1 && len == 2) {
                    System.out.println("系统：" + name + "已下线");
                    continue;
                }
                // 聊天语句输出
                System.out.println(name + "：" + word);
            }
        } catch (Exception e) {
            System.out.println("服务器异常，等待修复...");
        }
    }

    private String getValue(String key) {
        String name = "隔壁老王";
        // 加载properties数据
        Properties pp = new Properties();
        try {
            pp.load(new FileInputStream("javaee11/upload/users.properties"));
        } catch (IOException e) {
        }
        // 取出value
        String value = pp.getProperty(key);
        if (null != value)
            name = value;
        return name;
    }
}
