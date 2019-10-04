package com.fovsoft.controller;

import com.fovsoft.StartupApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartupApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    public void setUp() throws Exception{
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("http://localhost:%d/", port));
        this.base = new URL(url);
    }

    @Test
    public void testLogin() {
        ResponseEntity<String> response = this.restTemplate.getForEntity(this.base.toString() + "/test", String.class, "");

        System.out.println(String.format("测试结果: %s", response.getBody()));

    }
}
