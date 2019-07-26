package com.hsc.demo9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * TCP服务器实现多人同时传输图片:
 * 1. 多人用while(true)实现，同时用多线程实现;
 * 2. 多线程分别用Thread和Runnable实现;
 * 3. 文件名与时间，ip关联。
 * 4. 服务器无需关闭
 */
public class TCPServerPro {
    public static void main(String[] args) throws Exception {

        // 创建ServerSocket对象服务器server
        ServerSocket server = new ServerSocket(2021);
        System.out.println("服务器启动...");
        /*
        多人连接，多人上传，循环实现。
         */
        while (true) {
            // server接收客户端请求，得到socket
            Socket socket = server.accept();
            String fileName = getFileName(socket);
            /*
            同时上传，多线程实现。
            异常只能try...catch...
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try (
                            // 获取socket输入流，并写出到指定路径
                            InputStream in = socket.getInputStream();
                            FileOutputStream fos = new FileOutputStream(fileName);
                            // 获取socket输出流，返回结果信息给客户端
                            OutputStream out = socket.getOutputStream();
                    ) {
                        int len;
                        byte[] bytes = new byte[8192];
                        while ((len = in.read(bytes)) != -1) {
                            fos.write(bytes, 0, len);
                        }
                        System.out.println("服务器成功保存");
                        out.write("服务器接收成功".getBytes());
                    } catch (IOException e) {
                        System.out.println("上传失败");
                    }
                }
            }).start();
        }
    }

    private static String getFileName(Socket socket) {
        StringBuilder sb = new StringBuilder();
        // 获取客户端ip，随机数，系统时间等信息。
        String ip = socket.getInetAddress().getHostAddress().replace(".", "");
        String name = sb.append("javaee11/upload/")
                .append(System.currentTimeMillis())
                .append("_")
                .append(new Random().nextInt(8888))
                .append("_")
                .append(ip)
                .append(".png")
                .toString();

        return name;
    }
}
