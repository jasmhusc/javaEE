package com.hsc.otherio;

import java.io.*;

/**
 * 读写顺序必须一致
 */
public class DataIO_Demo {

    public static void main(String[] args) throws IOException {
        //write();
        DataInputStream dis = new DataInputStream(new FileInputStream("dos.txt"));

        int i = dis.readInt();
        System.out.println(i);

        short s = dis.readShort();
        System.out.println(s);

        double d = dis.readDouble();
        System.out.println(d);

        long l = dis.readLong();
        System.out.println(l);

        boolean b = dis.readBoolean();
        System.out.println(b);

        byte by = dis.readByte();
        System.out.println(by);

        char c = dis.readChar();
        System.out.println(c);

        // 关流
        dis.close();

    }

    private static void write() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("dos.txt"));

        dos.writeInt(1024);
        dos.writeShort(13);
        dos.writeDouble(3.14);
        dos.writeLong(500000);
        dos.writeBoolean(true);
        dos.writeByte(1);
        dos.writeChar('d');
        //dos.writeChars("HelloWorld");  只能一次读一个

        dos.close();
    }
}
