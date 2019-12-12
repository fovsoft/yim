package com.fovsoft.controller.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fovsoft.common.JsonResult;
import com.fovsoft.entity.*;
import com.fovsoft.service.FamilySerivce;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.buf.StringUtils;
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

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public JsonResult del(Integer id) {
        int returnId = familySerivce.del(id);

        return new JsonResult(Integer.valueOf(returnId));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JsonResult get(Integer id) {
        YmFamilyBase ymFamilyBase = familySerivce.get(id);
        return new JsonResult(ymFamilyBase);
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
    public JsonResult getMemberList(Integer fid) {
        List<YmFamilyBaseMember> list = familySerivce.getMemberList(fid);

        return new JsonResult(list);
    }

    @RequestMapping(value = "/getMember", produces = "application/json;charset=UTF-8")
    public JsonResult getMember(Integer id) {
        YmFamilyBaseMember member = familySerivce.getMember(id);
        return new JsonResult(member);
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addMember(@RequestBody YmFamilyBaseMember ymFamilyBaseMember) {
        int id = familySerivce.addOrUpdateFamilyBaseMember(ymFamilyBaseMember);
        return new JsonResult(Integer.valueOf(id));
    }

    @RequestMapping(value = "/updateMember", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult updateMember(@RequestBody YmFamilyBaseMember ymFamilyBaseMember) {
        int id = familySerivce.addOrUpdateFamilyBaseMember(ymFamilyBaseMember);
        return new JsonResult(Integer.valueOf(id));
    }

    @RequestMapping(value = "/delMember", method = RequestMethod.GET)
    public JsonResult delMember(Integer id) {
        int returnId = familySerivce.delMember(id);
        return new JsonResult(Integer.valueOf(returnId));
    }

    /**
     * 批量删除
     *
     * 多表批量删除，没加事务
     *
     * @return
     */
    @RequestMapping(value = "/delAll",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult delAll(@RequestBody ArrayList<Integer> ids) {
        String inStr = "";
        for (int i:
        ids) {
            inStr += i + ",";
        }
        inStr = inStr.substring(0, inStr.length() - 1); logger.info(inStr);
        familySerivce.delAll(inStr);
        return new JsonResult();
    }

    @RequestMapping(value = "/getAddition",  produces = "application/json;charset=UTF-8")
    public JsonResult getAddiction(Integer fid) {
        YmFamilyBaseAddition ymFamilyBaseAddition = familySerivce.getAddiction(fid);
        return new JsonResult(ymFamilyBaseAddition);
    }

    @RequestMapping(value = "/getCondition",  produces = "application/json;charset=UTF-8")
    public JsonResult getCondition(Integer fid) {
        YmFamilyBaseCondition ymFamilyBaseCondition = familySerivce.getCondition(fid);
        return new JsonResult(ymFamilyBaseCondition);
    }
}
