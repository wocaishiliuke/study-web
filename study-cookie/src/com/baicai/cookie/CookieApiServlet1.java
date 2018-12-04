package com.baicai.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "cookieApiServlet1", urlPatterns = "/cookieApiServlet1" /*"/cookieApiServlet1/a/b"*/, loadOnStartup = 1)
public class CookieApiServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /** 创建Cookie */
        //Cookie cookie1 = new Cookie("username", "你好Cookie1");
        Cookie cookie2 = new Cookie("username", "你好Cookie2");
        //cookie2.setVersion(1);
        //cookie2.setComment("cookie2 purpose: test");
        //cookie2.setPath("/");
        //cookie2.setPath("/c");
        //cookie2.setDomain(".baidu.com");//要包含当前域名
        //cookie2.setMaxAge(10);
        //cookie2.setSecure(true);
        //cookie2.setHttpOnly(true);

        //resp.addCookie(cookie1);
        resp.addCookie(cookie2);

        resp.setContentType("text/html;charset=utf-8");
        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        resp.getWriter().println("发送Cookie的时间为：" + current);

        /** 获取Cookie */
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie3 : cookies) {
                System.out.println(cookie3.getName() + ": " + cookie3.getValue());
            }
        }

    }
}
