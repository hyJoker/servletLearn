package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: create by Administrator
 * @version: v1.0
 * @description: com.servlet
 * @date:2018/11/28
 * 测试servlet响应http请求 使用注解,不用在web.xml中配置
 */
@WebServlet("/hello")
public class HelloWorld extends HttpServlet {

    private String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容类型
        resp.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("---destory---");
    }

    @Override
    public void init() throws ServletException {
        message = "hello world!!!!";
        System.out.println("---init---");
    }
}
