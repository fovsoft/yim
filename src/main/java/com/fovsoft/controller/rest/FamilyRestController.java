package com.fovsoft.controller.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fovsoft.common.JsonResult;
import com.fovsoft.entity.YmFamilyBase;
import com.fovsoft.entity.YmFamilyBaseAddition;
import com.fovsoft.entity.YmFamilyBaseCondition;
import com.fovsoft.service.FamilySerivce;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/family")
public class FamilyRestController {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    FamilySerivce familySerivce;

    @RequestMapping(value = "/getList")
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
//        result.put("data", list);
        result.put("msg", "");
        result.put("count", 1);
        result.put("code", 0);
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult add(@RequestBody YmFamilyBase ymFamilyBase) {
        int id = familySerivce.addOrUpdateFamilyBase(ymFamilyBase);
        return new JsonResult(Integer.valueOf(id));
    }


    /**
     *
     * @param ymFamilyBaseAddition
     * @return
     */
    @RequestMapping(value = "/addAddition", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addAddition(@RequestBody YmFamilyBaseAddition ymFamilyBaseAddition) {
        int id = familySerivce.addOrUpdateFamilyBaseAddition(ymFamilyBaseAddition);
        return new JsonResult(Integer.valueOf(id));
    }

    /**
     *
     * @param ymFamilyBaseCondition
     * @return
     */
    @RequestMapping(value = "/addCondition", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addCondition(@RequestBody YmFamilyBaseCondition ymFamilyBaseCondition) {
        int id = familySerivce.addOrUpdateFamilyBaseCondition(ymFamilyBaseCondition);
        return new JsonResult(Integer.valueOf(id));
    }

    @RequestMapping(value = "/getMemberList",  produces = "application/json;charset=UTF-8")
    public JsonResult getFamilyMember() {

        return new JsonResult();
    }
}
