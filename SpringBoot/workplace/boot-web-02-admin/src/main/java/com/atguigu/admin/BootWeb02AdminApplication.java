package com.atguigu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


//@ServletComponentScan(basePackages = "com.atguigu.admin")
@MapperScan("com.atguigu.admin.mapper")
@SpringBootApplication
public class BootWeb02AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWeb02AdminApplication.class, args);
    }

}
