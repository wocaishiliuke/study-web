package com.baicai.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 用于测试ServletContext
 */
@WebServlet(name = "servlet5", urlPatterns = "/hello5", loadOnStartup = 4)
public class Servlet5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** ServletContext API测试 */
        //ServletContext context = this.getServletConfig().getServletContext();
        ServletContext context = this.getServletContext();

        context.setAttribute("attrKey", "attr值1");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("attrParam: attrKey=" + context.getAttribute("attrKey") + "<br/>");
        Enumeration<String> attributeNames = context.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attrKey = attributeNames.nextElement();
            resp.getWriter().println("attrParam: " + attrKey + "=" + context.getAttribute("attrKey") + "<br/>");
        }
        resp.getWriter().println("------------------" + "<br/>");

        String value1 = (String) context.getInitParameter("key1");
        resp.getWriter().println("contextParam: key1=" + value1 + "<br/>");
        Enumeration<String> initParameterNames = context.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String key = initParameterNames.nextElement();
            String value = (String) context.getInitParameter(key);
            resp.getWriter().println("contextParam: " + key + "=" + value + "<br/>");
        }
        resp.getWriter().println("------------------" + "<br/>");

        resp.getWriter().println("ContextPath: " + context.getContextPath() + "<br/>");
        resp.getWriter().println("ServerInfo: " + context.getServerInfo() + "<br/>");
        resp.getWriter().println("ServletContextName: " + context.getServletContextName() + "<br/>");
        resp.getWriter().println("web.xml MimeType: " + context.getMimeType("web.xml") + "<br/>");
        resp.getWriter().println("web.xml RealPath: " + context.getRealPath("web.xml") + "<br/>");
        resp.getWriter().println("------------------" + "<br/>");

        /** ServletContext作为容器 */
        Integer count = (Integer) context.getAttribute("count");
        context.setAttribute("count", count == null ? 1 : ++count);
        resp.getWriter().println("第" + (count == null ? 1 : count) + "次访问...");
    }
}
