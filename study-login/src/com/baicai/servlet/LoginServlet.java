package com.baicai.servlet;

import com.baicai.pojo.User;
import com.baicai.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);

        UserService userService = new UserService();
        User existUser = userService.login(user);
        resp.setContentType("text/html;charset=utf-8");
        if (existUser != null) {
            resp.getWriter().println("登录成功!");
        }else {
            resp.getWriter().println("登录失败!");
        }
    }
}
