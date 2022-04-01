package com.fenlon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Image extends HttpServlet {

    // 验证码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 让浏览器自动刷新(5s)
        resp.setHeader("refresh", "5");

        // 创建图片
        BufferedImage img = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) img.getGraphics();  // 获取2D图片的画笔
        g.setColor(Color.white);  // 设置颜色
        g.fillRect(0, 0, 80, 20);  // 填充一个长方形

        g.setColor(Color.green);
        g.setFont(new Font(null, Font.BOLD, 20));  // 设置字体
        g.drawString(getCode(), 0, 20);

        // 向浏览器响应图片信息
        resp.setContentType("image/png");
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        ImageIO.write(img, "png", resp.getOutputStream());
    }

    private String getCode() {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            sb.append("0");
        }
        num = sb.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
