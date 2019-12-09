package com.fovsoft.controller;

import com.fovsoft.service.FamilySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IncomeController {

//    @Autowired
//    FamilySerivce familySerivce;

    @RequestMapping(value = "/income")
    public String index() {
        return "income";
    }

    @RequestMapping(value = "/income_add")
    public String incomeAdd() {
        return "income_add";
    }

}
