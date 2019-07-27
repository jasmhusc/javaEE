package com.hsc.test;

import java.util.ArrayList;

/**
 * 存储用户名和密码，充当数据库。
 */
public class UsersDB {

    private static ArrayList<Users> list = new ArrayList<>();

    static {
        list.add(new Users("aaaa", "bbbb"));
        list.add(new Users("kobe", "666666"));
        list.add(new Users("James", "8888"));
        list.add(new Users("Paul", "123456"));
        list.add(new Users("users", "password"));

    }

    public static ArrayList<Users> getUsers() {
        return list;
    }
}
