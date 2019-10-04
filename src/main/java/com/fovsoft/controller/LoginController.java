package com.fovsoft.controller;

import com.fovsoft.common.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {


    @RequestMapping("/login")
    public String login() {
        Map result = new HashMap();
        result.put("code", "200");
        result.put("msg", "OK");


        return "ggg";
    }

    @RequestMapping("/getMap")
    public JsonResult<Map> getMap() {
        Map result = new HashMap();
        result.put("code", "200");
        result.put("msg", "OK");
        result.put("som", null);
        return new JsonResult<>(result);
    }
}
