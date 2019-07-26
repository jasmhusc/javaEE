package com.hsc.demo9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class ServerTask implements Runnable {
    private Socket socket;

    public ServerTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String fileName = getFileName(socket);
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
