package com.baicai.cookie;

import com.baicai.util.CookieUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "cookieApiServlet3", urlPatterns = "/cookieApiServlet3", loadOnStartup = 1)
public class CookieApiServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取上次访问时间
        String value = CookieUtils.getCookieValueByName(req.getCookies(), "lastAccess");
        resp.setContentType("text/html;charset=utf-8");
        if (value == null) {
            resp.getWriter().println("欢迎光临!");
        } else {
            resp.getWriter().println("上次访问该Servlet的时间：" + URLDecoder.decode(value, "utf-8"));
        }

        //写回本次访问时间
        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Cookie cookie = new Cookie("lastAccess", URLEncoder.encode(current, "utf-8"));
        cookie.setMaxAge(60 * 60 * 24 * 7);
        cookie.setPath("/cookie/cookieApiServlet3");
        resp.addCookie(cookie);
    }
}
