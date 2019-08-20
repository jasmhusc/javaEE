package com.hsc.entity;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {

        /*
         sql的Date为：yyyy-MM-dd
         sql的TimeStamp:yyyy-MM-dd HH:mm:ss
         */
        User aa = new User("aa", 12, Date.valueOf("1999-09-23"));
        System.out.println("aa = " + aa);
    }
}
