package com.fovsoft.controller.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fovsoft.common.JsonResult;
import com.fovsoft.entity.YmFamilyBase;
import com.fovsoft.entity.YmFamilyBaseAddition;
import com.fovsoft.entity.YmFamilyBaseCondition;
import com.fovsoft.entity.YmFamilyBaseMember;
import com.fovsoft.service.FamilySerivce;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/family")
public class FamilyRestController {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    FamilySerivce familySerivce;

    @RequestMapping(value = "/getList")
    public Object index(Integer page, Integer limit) {
        logger.info(page + " " + limit);
        PageInfo pageInfo = familySerivce.getList(page, limit);

        Map result = new HashMap();
        result.put("data", pageInfo.getList());
        result.put("msg", "");
        result.put("count", pageInfo.getTotal());
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
    public JsonResult getMemberList() {

        return new JsonResult();
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addMember(@RequestBody YmFamilyBaseMember ymFamilyBaseMember) {
        int id = familySerivce.addOrUpdateFamilyBaseMember(ymFamilyBaseMember);
        return new JsonResult(Integer.valueOf(id));
    }
}
