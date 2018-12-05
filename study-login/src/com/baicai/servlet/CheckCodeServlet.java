package com.baicai.servlet;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成验证码，并保存到Session
 */
@WebServlet(name = "checkCodeServlet", urlPatterns = "/checkCode", loadOnStartup = 1)
public class CheckCodeServlet extends HttpServlet {

    private final static String codeData = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /** 1.创建图画 */
        int width = 120;
        int height = 40;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 1.1 获取Graphics，用来draw into the bufferedImage
        Graphics graphics = bufferedImage.getGraphics();
        // 1.2 填充背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);
        // 1.3 绘制边框
        graphics.setColor(Color.red);
        graphics.drawRect(0, 0, width - 1, height - 1);

        /** 2.生成验证码 */
        // 2.1生成4位码
        Random r = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            // 设置字体和随机颜色
            graphics.setFont(new Font("宋体", Font.ITALIC, 25));
            graphics.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            String str = codeData.charAt(r.nextInt(codeData.length())) + "";
            graphics.drawString(str, 15 + i * 25, 30);
            code += str;
        }
        // 2.2 干扰线
        for (int i = 0; i < 5; i++) {
            // 设置随机颜色
            graphics.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            graphics.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
        }

        /** 3.保存验证码到session */
        req.getSession().setAttribute("session_checkCode", code);
        System.out.println("图形验证码:" + code);

        /** 4.将图画输出到浏览器 */
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }
}
