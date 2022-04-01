package com.fenlon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class File extends HttpServlet {

    // 文件下载
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取文件下载路径
        String realPath = this.getServletContext().getRealPath("/1.png");
        // 获取文件名
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // 设置响应头信息
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        // 生成下载文件输入流
        FileInputStream in = new FileInputStream(realPath);
        // 使用缓冲区将文件流通过响应输出流输出到客户端
        int len = 0;
        byte[] buf = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
