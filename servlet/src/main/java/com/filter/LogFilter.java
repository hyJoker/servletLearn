package com.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author: create by Administrator
 * @version: v1.0
 * @description: com.filter
 * @date:2018/11/29
 */
public class LogFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        String site = filterConfig.getInitParameter("site");
        System.out.println("site : "+site);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("---filter---");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
