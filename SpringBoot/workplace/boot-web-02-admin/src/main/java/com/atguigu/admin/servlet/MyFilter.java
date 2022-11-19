package com.atguigu.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns={"/css/*","/images/*"})
//servlet包含全部的子文件夹用"/*",spring用”/**“
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFliter的init()方法");
    }

    @Override
    public void destroy() {
        log.info("MyFilter的destory()方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter的doFilter()方法");
        chain.doFilter(request,response);
    }
}
