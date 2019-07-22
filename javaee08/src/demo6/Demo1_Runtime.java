package demo6;

import java.io.IOException;

import javax.management.RuntimeErrorException;

/**
 * 每个Java应用程序都有一个Runtime类的Runtime ，允许应用程序与运行应用程序的环境进行接口。
 * Rumtime.getRuntime()--当前运行时可以从getRuntime获取。
 * 单例模式--应用程序无法创建自己的此类的实例。
 */
public class Demo1_Runtime {

    public static void main(String[] args) throws IOException {

        Runtime r = Runtime.getRuntime();
        //r.exec("shutdown -s -t 300");
        r.exec("shutdown -a");

    }

}
