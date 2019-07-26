package com.hsc.demo6;

/**
 * Socket类构造方法：
 *    Socket(String host, int port)
 *       根据ip地址字符串和端口号创建客户端Socket对象
 *       注意事项：只要执行该方法，就会立即连接指定的服务器程序，如果连接不成功，则会抛出异常。
 *       如果连接成功，则表示三次握手通过。
 * Socket类常用方法：
 *       OutputStream getOutputStream(); 获得字节输出流对象
 *       InputStream getInputStream();获得字节输入流对象
 * TCP协议的使用场景：
 *       文件上传和下载
 *       邮件发送和接收
 *       远程登录
 */
public class TCPIntro {
}
