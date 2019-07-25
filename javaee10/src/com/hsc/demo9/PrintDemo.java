package com.hsc.demo9;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 1. public PrintStream(String fileName) ： 使用指定的文件名创建一个新的打印流。
 * 2. System.out 就是 PrintStream 类型的，只不过它的流向是系统规定的，打印在控制台上。
 * 不过，既然是流对象，我们就可以玩一个"小把戏"，将数据输出到指定文本文件中。
 */
public class PrintDemo {
    public static void main(String[] args) throws FileNotFoundException {

        /*
        在代码的某些地方添加一些打印信息,开发的时候打印在控制台,项目部署的时候,打印到文件
        收集log信息
         */
        // 调用系统的打印流,控制台直接输出数据
        System.out.println("javaee");
        System.out.println(97);
        System.out.println('H');

        // 创建打印流,指定文件的名称
        PrintStream ps = new PrintStream("javaee10/file/ps.txt");

        // 设置系统的打印流流向,输出到ps.txt
        System.setOut(ps);  // 参数为PrintStream类型

        // 调用系统的打印流,ps.txt中输出数据
        ps.println("javabase");
        ps.println(98);
        ps.println(true);

        // 关流
        ps.close();
    }
}
