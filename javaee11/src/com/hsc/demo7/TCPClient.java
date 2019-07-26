package com.hsc.demo7;

import java.io.*;
import java.net.Socket;

/**
 * 实现客户端的文本文件传输到服务器
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        // 1.创建客户端
        Socket socket = new Socket("127.0.0.1", 2019);
        // 2.得到Socket的输出流
        OutputStream out = socket.getOutputStream();
        // 3.创建文件输入流
        FileInputStream fis = new FileInputStream("javaee11/upload/cc.txt");
        // 4.循环读写数据
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        // 返回传输完毕信息给服务器
        socket.shutdownOutput();
        System.out.println("上传成功");
        // 5.得到Socket的输入流
        InputStream in = socket.getInputStream();
        // 6.读取数据
        byte[] arr = new byte[1024];
        int read = in.read(arr);
        System.out.println(new String(arr, 0, read));
        // 7.关闭资源
        in.close();
        fis.close();
        out.close();
        socket.close();
    }
}
