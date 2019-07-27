package com.hsc.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Test_UpdateClient {

    public static void main(String[] args) throws Exception {
        //1. 提示输入上传的文件路径是否存在，及是否是文件夹
        File file = getFile();

        //2. 发送文件名到服务端
        Socket socket = new Socket("127.0.0.1", 8050);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println(file.getName());

        //6. 接收结果，如果存在给予提示，程序直接退出
        String line = br.readLine();
        if ("存在".equals(line)) {
            System.out.println("文件已经存在，无需上传！");
            socket.close();
            return;
        }

        //7. 如果不存在，定义FileInputStream读取文件，写出到网络
        FileInputStream fis = new FileInputStream(file);

        int len;
        byte[] arr = new byte[8192];
        while ((len = fis.read(arr)) != -1) {
            ps.write(arr, 0, len);
        }
        System.out.println("上传成功");
        fis.close();
        socket.close();

    }

    private static File getFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件路径：");

        while (true) {
            File file = new File(sc.nextLine());
            if (file.exists() && file.isFile()) {
                return file;
            } else
                System.out.println("文件路径不存在或不正确，请重新录入！");
        }
    }
}
