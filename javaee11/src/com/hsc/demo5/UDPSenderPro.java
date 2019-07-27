package com.hsc.demo5;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPSenderPro implements Runnable {
    @Override
    public void run() {
        try {
            // 上线，准备发送数据。
            DatagramSocket socket = new DatagramSocket();
            byte[] loadin = new byte[]{-1, -1, -1};
            DatagramPacket packet = new DatagramPacket(loadin, loadin.length, InetAddress.getLocalHost(), 5555);
            socket.send(packet);
            // 读取输入信息，发送到聊天室
            while (true) {
                String word = new Scanner(System.in).nextLine();
                if ("bye".equals(word)) {
                    byte[] loadout = new byte[]{-1, -1};
                    DatagramPacket p = new DatagramPacket(loadout, loadout.length, InetAddress.getLocalHost(), 5555);
                    socket.send(p);
                    break;
                }
                byte[] buf = word.getBytes();
                DatagramPacket p = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 5555);
                socket.send(p);
            }
            socket.close();
        } catch (SocketException e) {
            System.out.println("网络出现问题，您已断开连接！");
        } catch (UnknownHostException e) {
            System.out.println("ip地址被占用！");
        } catch (IOException e) {
        }
    }
}
