package com.baicai.servlet;

import com.baicai.pojo.User;
import com.baicai.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** 验证码校验 */
        String realCode = (String) req.getSession().getAttribute("session_checkCode");
        String formcode = (String) req.getParameter("form_checkCode");
        //及时清理
        req.getSession().removeAttribute("session_checkCode");
        if (realCode == null || !realCode.equals(formcode)) {
            req.setAttribute("errorMsg", "验证码错误！");
            // 转发，而非重定向（同一个request对象，才能获取到错误信息）
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        /** 认证 */
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);
        UserService userService = new UserService();
        User existUser = userService.login(user);
        resp.setContentType("text/html;charset=utf-8");
        if (existUser != null) {
            // 登录成功，才写Cookie
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(cookie);
            // 写session，JSP中可以获取
            req.getSession().setAttribute("user", existUser);

            //resp.getWriter().println("登录成功!");
            // 登录成功，通知浏览器重定向到首页
            // 可以使用相对路径，也可以使用绝对路径/contextPath/index.jsp（重定向的浏览器行为，客户端路径）
            resp.sendRedirect("index.jsp");
        }else {
            //resp.getWriter().println("登录失败!");
            // 登录失败，再转发到登录页
            // 可以使用相对路径，也可以使用绝对路径/login.jsp（转发的服务器行为，服务端路径不需要加contextPath）
            req.setAttribute("errorMsg", "用户名或密码错误，请重试！");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
