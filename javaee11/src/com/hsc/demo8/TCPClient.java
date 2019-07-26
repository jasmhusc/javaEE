package com.hsc.demo8;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 上传图片至服务器
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {

        // 创建socket对象，请求服务器
        Socket socket = new Socket("127.0.0.1", 2021);
        System.out.println("客户端启动...");

        // 获取socket输出流，文件输入流，写出文件
        OutputStream out = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("F:\\myjavafile\\firstdir\\ironman.gif");
        int len;
        byte[] bytes = new byte[1024 * 4];
        while ((len = fis.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        // 写出结束信号
        socket.shutdownOutput();
        System.out.println("客户端上传成功");

        // 获取socket输入流，接收服务器反馈信息
        InputStream in = socket.getInputStream();
        byte[] arr = new byte[1024];
        int read = in.read(arr);
        System.out.println(new String(arr, 0, read));

        // 关闭资源
        in.close();
        fis.close();
        out.close();
        socket.close();
    }
}
