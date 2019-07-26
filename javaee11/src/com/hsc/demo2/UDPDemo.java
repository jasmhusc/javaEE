package com.hsc.demo2;

/**
 * Datagrampacket类的API(数据包)：
 * Datagram(byte[] buf, int length)
 * 创建空数据包，用来接收数据（接收发送来的数据的包）。
 * <p>
 * Datagram(byte[] buf, int offset, int length, InetAdress adrees, int port)
 * 创建有数据的包，用来发送。
 * byte[] buf：发送的数据，是字节数组；
 * int offset：数据的开始索引；
 * int length：发送数据的长度；
 * InetAdress adrees：指定接收端的ip地址对象，发给谁；
 * int port：指定端口号；
 * UDP协议的使用场景
 *          即时通讯
 *          在线视频
 *          网络语音电话
 */
public class UDPDemo {
}
