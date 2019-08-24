package com.hsc.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CheckCodeServlet", urlPatterns = "/vcode")
public class CheckCodeServlet extends HttpServlet {
    // 全局变量，用于生成随机元素
    private Random random = new Random();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        // 生成验证码图片
        // 1. 画150x50的填充矩形
        // 创建的是内存图片，new BufferedImage()
        BufferedImage image = new BufferedImage(150, 50, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 24));
        g.fillRect(0, 0, 150, 50);

        // 2. 画148x48的矩形边框
        g.drawRect(1, 1, 148, 48);

        // 3. 画4条干扰线
        for (int i = 0; i < 4; i++) {
            // 生成线的坐标，包含两个点
            int x1 = random.nextInt(140);
            int y1 = random.nextInt(40);
            int x2 = random.nextInt(140);
            int y2 = random.nextInt(40);
            // 画线
            // 设置颜色
            Color color = getRandomColor();
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
        }

        // 4. 画4个字符
        String charResource = "qwertyupasdfghjklzxcvbnmQWERTYUPASDFGHJKLZXCVBNM23456789";
        StringBuilder checkCode = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            // 随机生成索引，根据索引获取字符
            int index = random.nextInt(charResource.length());
            char c = charResource.charAt(index);
            // 将字符画到方框内的制定位置，没有画字符的，用画字符串的api
            checkCode.append(c);
            g.setColor(getRandomColor());
            g.drawString(String.valueOf(c), 20 + 30 * i, 35);
        }

        // 5.将验证码存储进session
        HttpSession session = request.getSession();
        session.setAttribute("Server_CheckCode", checkCode.toString());

        // 6. 将图片输出到浏览器
        try {
            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(image, "png", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Color getRandomColor() {
        // Color​(int r, int g, int b)
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        Color color = new Color(r, g, b);
        return color;
    }
}
