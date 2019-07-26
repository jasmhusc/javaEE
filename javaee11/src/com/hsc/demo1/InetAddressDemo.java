package com.hsc.demo1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *  * InetAddress类概述:
 *  *     一个该类的对象就代表一个IP地址对象。
 * <p>
 *  * InetAddress类成员方法:
 *  *     static InetAddress getLocalHost():
 * 获得本地主机IP地址对象
 *  *     static InetAddress getByName(String host):
 * 根据IP地址字符串或主机名获得对应的IP地址对象
 * <p>
 *  *     String getHostName(): 获得主机名
 *  *     String getHostAddress(): 获得IP地址字符串
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {

        // 获得本地主机IP地址对象
        InetAddress inet1 = InetAddress.getLocalHost();
        System.out.println(inet1);
        // DESKTOP-EK03HCP/192.168.84.47

        // 根据IP地址字符串或主机名获得对应的IP地址对象
        InetAddress inet2 = InetAddress.getByName("baidu.com");
        InetAddress inet3 = InetAddress.getByName("220.181.38.148");
        System.out.println(inet2 + "::" + inet3);
        // baidu.com/220.181.38.148::/220.181.38.148

        // 获得主机名
        String hostName = inet1.getHostName();
        System.out.println(hostName);
        // DESKTOP-EK03HCP

        // 获得IP地址字符串
        String hostAddress = inet1.getHostAddress();
        System.out.println(hostAddress);
        // 192.168.84.47
    }
}
