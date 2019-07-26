package com.hsc.demo9;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端传输图片资源，实现指定路径传入。
 */
public class TCPClientPro {
    public static void main(String[] args) throws Exception {

        // 创建socket对象，请求服务器
        Socket socket = new Socket("127.0.0.1", 2021);
        System.out.println("客户端启动...");

        // 获取图片资源输入流，socket输出流
        FileInputStream fis = new FileInputStream("F:/myjavafile/cmd.png");
        OutputStream out = socket.getOutputStream();
        int len;
        byte[] bytes = new byte[8192];
        while ((len = fis.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        socket.shutdownOutput();
        System.out.println("客户端上传成功");

        // 获取socket输入流，得到服务器返回的信息
        InputStream in = socket.getInputStream();
        byte[] arr = new byte[2048];
        int length = in.read(arr);
        System.out.println(new String(arr, 0, length));

        // 关闭资源
        in.close();
        fis.close();
        out.close();
        socket.close();
    }
}
