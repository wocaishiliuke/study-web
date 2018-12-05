package com.baicai.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "sessionServlet1", urlPatterns = "/sessionServlet1", loadOnStartup = 1)
public class SessionServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置Session
        HttpSession session = req.getSession();
        session.setAttribute("ip", req.getRemoteAddr());
        System.out.println(session.getMaxInactiveInterval());
        session.invalidate();

        //持久化JSESSIONID Cookie
        /*Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setPath("/session");//contextPath
        cookie.setMaxAge(60 * 60 * 24 * 7);
        resp.addCookie(cookie);*/

        //resp.setContentType("text/html;charset=utf-8");
        //resp.getWriter().println("ip已保存到Session容器，请<a href='/session/sessionServlet2'>点击</a>查看");

        //URL重写
        //方式1
        //resp.setContentType("text/html;charset=utf-8");
        //resp.getWriter().println("ip已保存到Session容器，请<a href='" + resp.encodeURL("/session/sessionServlet2") + "'>点击</a>查看");
        //方式2
        resp.sendRedirect(resp.encodeRedirectURL("/session/sessionServlet2"));
    }
}
