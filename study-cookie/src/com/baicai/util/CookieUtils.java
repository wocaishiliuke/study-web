package com.baicai.util;

import javax.servlet.http.Cookie;

public class CookieUtils {

    // 私有空参构造
    private CookieUtils() {};

    /**
     * 根据name，获取Cookie的value
     */
    public static String getCookieValueByName(Cookie[] cookies, String name) {
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
