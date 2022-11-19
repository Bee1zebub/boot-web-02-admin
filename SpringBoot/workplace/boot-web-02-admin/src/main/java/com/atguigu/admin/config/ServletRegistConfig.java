package com.atguigu.admin.config;

import com.atguigu.admin.servlet.MyFilter;
import com.atguigu.admin.servlet.MyServlet;
import com.atguigu.admin.servlet.MyServletContextListener;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;
import java.util.Arrays;

//!细节一：proxyBeanMethods = true，保证依赖的组件时单实例的
@Configuration(proxyBeanMethods = true)
public class ServletRegistConfig {

    //注入原生Servlet
    @Bean
    public ServletRegistrationBean<HttpServlet> myServlet(){
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet,"/my","/my01");
    }

    //注入原生Filter
    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*","/my","/my01"));
        return filterRegistrationBean;
    }

    //注入原生Listener
    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }


    /*@Bean
    public ConfigurableServletWebServerFactory MyServletFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(9000);
        return factory;
    }*/
}
