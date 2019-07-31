package com.hsc.demo11;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient implements Runnable {
    private String ipstr;
    private int port;

    public TCPClient(String ipstr, int port) {
        this.ipstr = ipstr;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            // 获取服务器的ip和port，建立连接
            InetAddress ip = InetAddress.getByName(ipstr);
            Socket socket = new Socket(ip, port);

            // 获取控制台的输入流，将其写出
            Scanner sc = new Scanner(System.in);
            OutputStream out = socket.getOutputStream();

            // 获取本地hostname
            String name = InetAddress.getLocalHost().getHostName();
            while (true) {
                // 传递数据
                System.out.print(name + ": ");
                String line = sc.nextLine();
                if ("bye".equals(line))
                    break;
                out.write(line.getBytes());
                out.write("\r\n".getBytes());
            }
            // 退出
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("对方已下线...");
        }
    }
}
