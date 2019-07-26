package com.hsc.demo10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟web服务器：
 * 请求行：POST /examples/servlets/servlet/RequestParamExample HTTP/1.1
 * GET /web/index.html HTTP/1.1
 * 1. 服务器获取浏览器的发送请求信息的第一行，即请求行，解析出文件路径；
 * 2. 传给浏览器必要的协议信息语句内容；
 * 3. 根据路径将文件写出，传给浏览器。
 */
public class WebServer {
    public static void main(String[] args) throws Exception {

        // 开启服务器
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器启动...");
        while (true) {
            try {
                // 接收请求，并获取客户端信息
                Socket socket = server.accept();
                String ip = socket.getInetAddress().getHostAddress();
                System.out.println(ip + "请求连接...");
            /*
             读取http协议信息，打印输出;
             此信息是文字信息，应该用字符转换流；
             将请求行的内容解析出来;
              */
                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line = br.readLine();
                // 1.解析请求行: /web/head/index.html
                String path = "javaee11" + line.split(" ")[1];

                // 2.返回浏览器想要的数据
                OutputStream out = socket.getOutputStream();
                // 固定套路
                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                out.write("Content-Type:text/html\r\n".getBytes());
                out.write("\r\n".getBytes());

                // 3.写出path路径的数据
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
                BufferedOutputStream bos = new BufferedOutputStream(out);
                int len;
                byte[] bytes = new byte[8192];
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                System.out.println(ip + "连接成功！");

                // 关流
                bos.close();
                bis.close();
                br.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("请求失败");
            }
        }
    }
}
