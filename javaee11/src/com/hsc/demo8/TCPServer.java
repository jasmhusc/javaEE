package com.hsc.demo8;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收客户端上传的图片，并保存至本地。
 */
public class TCPServer {
    public static void main(String[] args) throws Exception {

        // 构建socket对象,接受客户端请求。
        ServerSocket server = new ServerSocket(2020);
        System.out.println("服务器启动...");
        Socket socket = server.accept();

        // 获取socket输入流，写出客户端上传数据到本地upload中
        InputStream in = socket.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("javaee11/upload/1.gif"));
        int len;
        byte[] bytes = new byte[1024 * 3];
        while ((len = in.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 获取socket输出流，返回结果信息
        OutputStream out = socket.getOutputStream();
        out.write("服务器接收成功".getBytes());

        // 关闭资源
        out.close();
        bos.close();
        in.close();
        socket.close();
        server.close();
    }
}
