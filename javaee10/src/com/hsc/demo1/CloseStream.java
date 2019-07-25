package com.hsc.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK1.7以前的:
 * 1.创建IO流的时候有异常,选择try...catch
 * 2.在finally中关闭IO流
 * 3.发现fis的作用域不够,将fis的定义放到try外面
 * 4.在finally中先判断fis!=null才去关流
 * 5.close又有异常,选择try...catch
 * 6.使用IO流读写数据又有异常
 * <p>
 * JDK1.7的处理方式:
 * try (创建流的代码) {
 * 操作流的代码
 * } catch (异常类名 变量名) {
 * }
 */
public class CloseStream {
    public static void main(String[] args) {

        // 关流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("javaee10/file/1.txt");
            fos = new FileOutputStream("javaee10/file/1_copy.txt");
            // 测试
            int read = fis.read();
            fos.write(read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (null != fos) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
