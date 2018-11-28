package com.servlet.test;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author: create by Administrator
 * @version: v1.0
 * @description: com.servlet.test
 * @date:2018/11/28
 */
public class ServletDemo2 extends GenericServlet {

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("------service------");
    }
}
