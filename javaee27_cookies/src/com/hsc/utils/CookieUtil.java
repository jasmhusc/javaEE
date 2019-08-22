package com.hsc.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {

    // 根据key寻找value
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
}
