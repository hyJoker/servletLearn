package com.servlet.test;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: create by Administrator
 * @version: v1.0
 * @description: com.servlet.test
 * @date:2018/11/28
 *
 * servlet的生命周期: 从servlet被创建到servlet被销毁的过程
 */

public class ServletDemo1 implements Servlet {

    //生命周期方法 : 第一次被创建的时候执行,在生命周期中只执行一次
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("------init------");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    //生命周期方法 : 对客户端响应的方法,该方法会被执行多次,每次请求都会执行
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("------service------");
    }

    public String getServletInfo() {
        return null;
    }

    //生命周期方法 : 销毁方法,tomcat关闭时会销毁
    public void destroy() {
        System.out.println("------destroy------");
    }
}
