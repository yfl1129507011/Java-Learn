package com.fenlon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("==========");
        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println("==========");

        // 将登录信息存放到cookie中
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            Cookie username1 = new Cookie("username", username);
            username1.setMaxAge(5*60*60);
            resp.addCookie(username1);
        }

        // session
        HttpSession session = req.getSession();
        session.setAttribute("password", password);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        resp.setCharacterEncoding("utf-8");


    }
}
