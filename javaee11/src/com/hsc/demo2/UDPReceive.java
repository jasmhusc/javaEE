package com.hsc.demo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *   UDP协议接收端代码实现
 */
public class UDPReceive {
    public static void main(String[] args) throws Exception {

        // 创建接收对象Datagramsocket
        DatagramSocket ds = new DatagramSocket(6666);
        // 创建字节数组存储数据
        byte[] buf = new byte[1024];
        // 创建数据包对象
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        // 接收数据
        ds.receive(dp);

        // 获得实际接收到的字节个数
        int len = dp.getLength();
        System.out.println("len = " + len);
        // 将字节数组的内容转换为字符串输出
        System.out.println(new String(buf, 0, len));

        // 获得发送端的信息：ip地址和端口号
        String sendIp = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        System.out.println("sendIp = " + sendIp);
        System.out.println("port = " + port);

        // 关闭socket对象
        ds.close();
    }
}
