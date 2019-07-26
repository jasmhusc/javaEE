package com.hsc.demo7;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收客户端床来的文本文件，并在控制台打印输出。
 */
public class TCPServer {
    public static void main(String[] args) throws Exception {
        // 1.创建服务端
        ServerSocket server = new ServerSocket(2019);
        // 2.同意客户端的请求
        Socket socket = server.accept();
        // 3.得到输入流
        InputStream in = socket.getInputStream();
        // 4.循环读写数据
        int len;
        byte[] bytes = new byte[1024];
        while ((len = in.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        // 5.得到输出流
        OutputStream out = socket.getOutputStream();
        // 6.发送数据给客户端
        out.write("接收成功".getBytes());
        // 7.关闭资源
        out.close();
        in.close();
        socket.close();
        server.close();
    }
}
