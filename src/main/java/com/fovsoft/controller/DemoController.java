package com.fovsoft.controller;


import com.fovsoft.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@RestController
public class DemoController {

    @RequestMapping("/login1")
    public JsonResult<Map> login() {
        Map result = new HashMap();
        result.put("code", "200");
        result.put("msg", "OK");
        return new JsonResult<>(result);
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
