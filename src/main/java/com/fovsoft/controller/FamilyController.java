package com.fovsoft.controller;

import com.fovsoft.common.JsonResult;
import com.fovsoft.service.FamilySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FamilyController {

    @Autowired
    FamilySerivce familySerivce;

    @RequestMapping(value = "/family")
    public String index() {
        return "family";
    }

    @RequestMapping(value = "/familyAdd")
    public String familyAdd() {
        return "family_add";
    }
}
