package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: create by Administrator
 * @version: v1.0
 * @description: com.servlet
 * @date:2018/11/28 servlet 处理响应头
 */
@WebServlet("/refresh")
public class Refresh extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置刷新自动加载时间为5s
        resp.setIntHeader("Refresh", 5);
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        //使用默认时区和语言环境获得一个日历
        Calendar calendar = Calendar.getInstance();
        //获取date
        Date date = calendar.getTime();
        //设置日期输出格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(date);
        PrintWriter writer = resp.getWriter();
        String title = "自动刷新 Header 设置 - 菜鸟教程实例";
        String docType =
                "<!DOCTYPE html>\n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>当前时间是：" + nowTime + "</p>\n");
    }
}
