package com.baicai.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cookieApiServlet2", urlPatterns = "/cookieApiServlet2", loadOnStartup = 1)
public class CookieApiServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        /** 删除Cookie */
        /* 方式1 */
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    System.out.println("删除Cookie---->" + cookie.getName());
                    cookie.setValue("");
                    //cookie.setValue(null);
                    //获取的不需要设置path，即相同
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }

        /* 方式2 */
        /*Cookie cookie = new Cookie("username", null);
        cookie.setPath("/cookie");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);*/
    }
}
