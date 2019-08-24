package com.hsc.util;

import javax.servlet.http.Cookie;

public class CookieUtils {

    // 根据key寻找cookie
    public static Cookie findCookie(Cookie[] cookies, String name) {
        Cookie cookie = null;
        if (cookies == null) {
            return cookie;
        }
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) {
                cookie = c;
            }
        }
        return cookie;
    }

    // 根据key寻找value
    public static String findCookieValue(Cookie[] cookies, String name) {
        String value = null;
        if (cookies == null) {
            return value;
        }
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) {
                value = c.getValue();
            }
        }
        return value;
    }
}
