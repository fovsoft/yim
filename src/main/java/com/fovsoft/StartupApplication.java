package com.fovsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@ServletComponentScan(basePackages = "com.fovsoft.*")
//@EnableAutoConfiguration(exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class // 禁用默认的security登录逻辑
//})
public class StartupApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(StartupApplication.class, args);
    }
}
