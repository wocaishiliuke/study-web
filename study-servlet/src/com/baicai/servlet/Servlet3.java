package com.baicai.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 测试Servlet的生命周期
 */
@WebServlet(name = "servlet3", urlPatterns = "/hello3")
public class Servlet3 implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet3 init...");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servlet3 service...");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet3 destroy...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
