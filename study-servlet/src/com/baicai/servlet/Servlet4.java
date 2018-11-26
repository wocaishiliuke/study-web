package com.baicai.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 用于测试ServletConfig
 */
@WebServlet(name = "servlet4", urlPatterns = "/hello4", loadOnStartup = 3,
        initParams = {@WebInitParam(name = "key1", value = "value1"), @WebInitParam(name = "key2", value = "中文")})
public class Servlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletConfig servletConfig = this.getServletConfig();
        String servletName = servletConfig.getServletName();
        ServletContext servletContext = servletConfig.getServletContext();
        String value1 = servletConfig.getInitParameter("key1");

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("servletName:" + servletName + "<br/>" +
                                "servletContext:" + servletContext + "<br/>" +
                                "value1:" + value1 + "<br/>");

        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String key = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(key);
            resp.getWriter().println("initParam:" + key + "=" + value + "<br/>");
        }
    }
}
