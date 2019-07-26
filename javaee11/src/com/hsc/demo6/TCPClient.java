package com.hsc.demo6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
TCP客户端代码实现步骤
    * 创建客户端Socket对象并指定服务器地址和端口号
    * 调用Socket对象的getOutputStream方法获得字节输出流对象
    * 服务器向客户端回写数据
    * 调用字节输出流对象的write方法往服务器端输出数据
    * 调用Socket对象的getInputStream方法获得字节输入流对象
    * 调用字节输入流对象的read方法读取服务器端返回的数据
    * 关闭Socket对象断开连接。
*/
public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 要发送的内容
        String str = "服务器你好！客户端请求连接！";
        // 创建Socket对象
        Socket socket = new Socket("192.168.84.47", 9999);
        System.out.println("客户端启动");

        // 获得字节输出流对象
        OutputStream out = socket.getOutputStream();
        // 输出数据到服务器端
        byte[] bytes = str.getBytes();
        out.write(bytes);

        // 获得字节输入流对象
        InputStream in = socket.getInputStream();
        // 创建字节数组：用来存储读取到服务器端数据
        byte[] arr = new byte[1024];
        // 读取服务器端返回的数据
        int b = in.read(arr);
        System.out.println(new String(arr, 0, b));

        // 关闭socket对象
        in.close();
        out.close();
        socket.close();
    }
}
