package com.hsc.demo3;

import java.io.*;

/**
 * 基本流读取一个字节
 * 基本流读取一个字节数组
 * 缓冲流读取一个字节
 * 缓冲流读取一个字节字节数组
 */
public class BufferedDemo {
    public static void main(String[] args) {
        // copy a music in 4 ways
        File file = new File("F:/myjavafile/dirs/一生所爱.mp3");

        long start = System.currentTimeMillis();
//        copy01(file); // 27796ms
        copy02(file); // 1024：55ms  8192：14ms
//        copy03(file); //200ms
//        copy04(file); // 18ms
        long end = System.currentTimeMillis();

        System.out.println("消耗时间：" + (end - start));
    }

    private static void copy01(File file) {
        // 基本流读取一个字节
        try (
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream("javaee10/file/copy.mp3");
        ) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void copy02(File file) {
        // 基本流读取一个字节数组
        try (
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream("javaee10/file/copy.mp3");
        ) {
            int len;
            byte[] arr = new byte[1024 * 8];
            while ((len = fis.read(arr)) != -1) {
                fos.write(arr, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy03(File file) {
        // 缓冲流读取一个字节
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("javaee10/file/copy.mp3"));
        ) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy04(File file) {
        // 缓冲流读取一个字节字节数组
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("javaee10/file/copy.mp3"))
        ) {
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1) {
                bos.write(arr, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
