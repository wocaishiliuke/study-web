package com.baicai.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 用于测试项目内读取文件
 */
@WebServlet(name = "servlet6", urlPatterns = "/hello6", loadOnStartup = 5)
public class Servlet6 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** 读取资源文件 */
        ServletContext context = this.getServletContext();

        //有时IDE会编译到/build/classes（Eclipse）或out（IDEA）目录下，但发布的时候还是会拷贝到/WEB-INF/classes下
        //d.txt不会被发布
        String aPath = context.getRealPath("/WEB-INF/classes/a.txt");
        String bPath = context.getRealPath("/b.txt");
        String cPath = context.getRealPath("/WEB-INF/c.txt");
        //System.out.println("项目路径为：" + req.getContextPath());//方式1
        System.out.println("项目路径为：" + context.getContextPath());
        System.out.println("a.txt的硬盘(真实)路径为===>" + aPath);
        System.out.println("b.txt的硬盘(真实)路径为===>" + bPath);
        System.out.println("c.txt的硬盘(真实)路径为===>" + cPath);
        System.out.println("a.txt的文件类型为：" + context.getMimeType(aPath));
        System.out.println("b.txt的文件类型为：" + context.getMimeType(bPath));
        System.out.println("c.txt的文件类型为：" + context.getMimeType(cPath));

        //读取文件内容,这里只读a文件的,其他的方式相同
        InputStream in = new FileInputStream(aPath);
        InputStreamReader isr = new InputStreamReader(in,"UTF-8");//这里只能是U8,因为项目编码是U8
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();//关一个流即可
    }
}
