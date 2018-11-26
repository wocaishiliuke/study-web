package com.baicai.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义servlet，xml配置
 */
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet2's doGet...");
        String value1 = this.getInitParameter("key1");
        String value2 = this.getInitParameter("key2");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(value1 + value2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet2's doPost...");
        this.doGet(request, response);
    }
}
