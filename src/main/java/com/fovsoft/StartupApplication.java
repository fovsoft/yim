package com.fovsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@ServletComponentScan(basePackages = "com.fovsoft.*")
public class StartupApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(StartupApplication.class, args);
    }
}
