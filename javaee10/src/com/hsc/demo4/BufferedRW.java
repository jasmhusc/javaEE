package com.hsc.demo4;

import java.io.*;

/**
 * 1.字符缓冲流的构造方法?
 * 需要一个基本流
 * <p>
 * 2.BufferReader特有方法?
 * String readLine(); 返回读取到的一行数据
 * <p>
 * 3.BufferedWriter特有方法?
 * void newLine() 写一个换行符
 */
public class BufferedRW {
    public static void main(String[] args) {
        // 用字符缓冲流复制文本:此java文件
        try (
                BufferedReader br = new BufferedReader(new FileReader("javaee10\\src\\com\\hsc\\demo4\\BufferedDemo.java"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("javaee10/file/copy.java"))
        ) {
            // 一次性读一行
            String line;
            while ((line = br.readLine()) != null) {
                // readLine遇到\r\n结束，但不包含\r\n，因此还需要再写出换行符
                bw.write(line);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
