package com.fovsoft.controller.rest;

import com.fovsoft.common.JsonResult;
import com.fovsoft.service.FamilySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FamilyRestController {

    @Autowired
    FamilySerivce familySerivce;

    @RequestMapping(value = "/getFamliyList")
    public Object index() {

        List list = new ArrayList();
        for(int i = 1; i < 20; i++) {
            Map data = new HashMap();
            data.put("id", i);
            data.put("zjhm", "45010217651023001" + i);
            data.put("hzxm", "王圣基" + i);
            data.put("pkhsx", "一般贫困户");
            data.put("jhtpnd", "2020");
            data.put("fpnd", "2019");
            data.put("sfydbqh", "是");
            list.add(data);
        }
        Map result = new HashMap();
        result.put("data", list);
        result.put("msg", "");
        result.put("count", 1);
        result.put("code", 0);
        return result;
    }

}
