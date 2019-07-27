package com.hsc.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test_UpdateServer {

    public static void main(String[] args) throws IOException {
        //3. 建立多线程服务器
        //4. 读取文件名

        ServerSocket server = new ServerSocket(8050);
        System.out.println("服务器准备就绪，已连接到端口号8050");
        while (true) {
            final Socket socket = server.accept();
            new Thread(() -> {
                try {
                    InputStream is = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    String fileName = br.readLine();
                    File dir = new File("javaee11/upload");
                    File file = new File(dir, fileName);

                    //5. 判断文件是否存在，将结果发回客户端
                    if (file.exists()) {
                        ps.println("存在");
                        socket.close();
                        return;
                    } else
                        ps.println("不存在");

                    //8. 定义FileOutputStream,从网络读取数据，存储到本地文件夹

                    FileOutputStream fos = new FileOutputStream(file);
                    int len;
                    byte[] arr = new byte[8192];
                    while ((len = is.read(arr)) != -1) {
                        fos.write(arr, 0, len);
                    }
                    fos.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
